Play 2.5 PDF module
-------------------

This module helps generating PDF documents dynamically from your Play! web application.
It simply renders your HTML- and CSS-based templates to PDF.
It is based on the Flying Saucer library, which in turn uses iText for PDF generation.

Usage
-----

I have provided a simple example application at
https://github.com/benjohnde/play20-pdf/tree/master/samples/pdf-sample.

You can use a standard Play! scala template like this one:
```html
@(message: String)

@main("Welcome to Play 2.0") {
    Image: <img src="/public/images/favicon.png"/><br/>
    Hello world! <br/>
    @message <br/>
}
```

Then this template, after having imported ```util.pdf.PDF```, can simply be rendered as:
```java
public static Result document() {
	return PDF.ok(document.render("Your new application is ready."));
}
```  
where ```PDF.ok``` is a simple shorthand notation for:
```java
ok(PDF.toBytes(document.render("Your new application is ready."))).as("application/pdf")
```

Template rules
--------------

Templates must generate XHTML.

If the template is using an image, stylesheet, etc., it usually is loaded via an http call.
The PDF modules tries to optimize that resource loading:
If you specify the URI as a path into the classpath of your Play! app, the resource is loaded directly instead.
See the above sample template for an example.

Of course you can link to CSS files in your class path also, but be aware not to
use the ``` media="screen"```qualifier. 
  
Fonts you use must be explicitely packaged with your app.
```html
<html>
	<head>
		<style type="text/css"><!--
		body {
			...
			font-family: FreeSans;
		}
		--></style>	
	</head>
	<body>
		...
	</body>
</html>
```
Since the FreeSans font is not available to the java VM, you are required to
add the corresponding font file, "FreeSans.ttf" to your Play! app.
The module adds ```/conf/resources/fonts``` to the list of directories
searched for font files.

Installation
------------

Currently the module is not hosted anywhere. In order to use it, you need to publish it locally in the current play-maven-repository. Therefore:

```bash
git clone https://github.com/benjohnde/play20-pdf.git
cd play20-pdf/module
activator publish-local
```

Then, add to your libraryDependencies in your ```build.sbt```:

```
libraryDependencies ++= Seq(
  "de.joergviola" %% "play-pdf" % "0.7-SNAPSHOT"
)
```

After the next restart of the typesafe-activator, the module should be available.
If you are using an IDE like Eclipse, remember to re-generate your project files. 


License
-------

Released under the MIT license; see the file LICENSE.
