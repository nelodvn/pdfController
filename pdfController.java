import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.html.simpleparser.HTMLWorker;
import com.lowagie.text.pdf.PdfWriter;

@RequestMapping(value = "toPdf", method = RequestMethod.POST)
	public void toPdf(
			@RequestBody(required=true) String body,
			@RequestBody(required=true) String cssUrl,
			HttpServletRequest request,
			HttpServletResponse response) throws DocumentException, UnsupportedEncodingException{

		StringBuffer html = new StringBuffer();
		html.append("<html>");
		html.append("<head>");
		html.append(cssUrl);
		html.append("</head>");
		html.append("<body>");
		body = URLDecoder.decode(body, "UTF8");
		html.append(body);
		html.append("</body>");
		html.append("</html>");
		
		try {
			response.reset();
			response.setContentType("application/pdf");
			Document doc = new Document(PageSize.A4);
			PdfWriter.getInstance(doc, response.getOutputStream());
			doc.open();
			HTMLWorker hw = new HTMLWorker(doc);
			hw.parse(new StringReader(html.toString()));
			doc.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
