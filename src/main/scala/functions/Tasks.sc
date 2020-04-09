/**
  * Write a tag function that takes three arguments: prefix, html, suffix
  * and evalues with a HTML code like: <div>Hello</div>
  * E.g:
  * tag("<div>", "<p>Hello world</p>", "</div>")
  * returns:
  * "<div><p>Hello world</p></div>"
  */
def tag(prefix: String, content: String, suffix: String) = prefix + content + suffix

/**
  * Then write more specialized versions of it.
  */

val tagWithDiv = tag("<div>", _: String, "</div>")
tagWithDiv("<p>Hello</p>")

val tagWithSpan = tag("<span>", _: String, "</span>")

tagWithDiv("<p>Hello, World</p>")

tagWithSpan("<p>Hello, World</p>")

/**
  * Implement a partial function by implementing PartialFunction trait,
  * that is defined only for strings longer than five characters and returns a tuple of the string itself and its length
  * E.g.
  * ("softwaremill", 12)
  */

val pf = new PartialFunction[String, (String, Int)] {
  def isDefinedAt(x: String) = x.length > 5

  def apply(v1: String) = (v1, v1.length)
}

/**
  * Reimplement the function above using case blocks
  */

val zipWithSize: PartialFunction[String, (String, Int)] = {
  case s if s.length > 5 => (s, s.length)
}

val list = List("softwaremill", "aaa").collect(zipWithSize)
