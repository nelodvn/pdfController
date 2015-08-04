# pdfController
Spring Restful Controller that converts html (with css) to pdf file, directly in browser, using a POST as input.

The controller receive html parameters (html body and css url) as post request body.
It uses itext (see imports) to generate the pdf file, and sends it back to client.

* Using

Just put the code snip as a controller in a Spring based (or other) rest controller, then:
POST localhost:8080/toPdf HTTP/1.1
body=<div>Hello world</div>
cssUrl=http://localhost:8080/style.css
