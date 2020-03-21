/*
 Write a tag function that takes three arguments: prefix, html, suffix
 and evalues with a HTML code like: <div>Hello</div>
 E.g:
   tag("<div>", "<p>Hello world</p>", "</div>")
 returns:
   "<div><p>Hello world</p></div>"
*/

def tag(prefix: String, content: String, suffix: String): String = ???

/*
 Then write more specialized versions of it.
*/

val tagWithDiv = ???
tagWithDiv("<p>Hello</p>")

val tagWithSpan = ???

tagWithDiv("<p>Hello, World</p>")

tagWithSpan("<p>Hello, World</p>")