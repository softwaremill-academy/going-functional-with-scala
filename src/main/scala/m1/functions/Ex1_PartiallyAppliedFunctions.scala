package m1.functions

class Ex1_PartiallyAppliedFunctions {

  /**
    * Write a tag function that takes three arguments: prefix, html, suffix
    * and evalues with a HTML code like: <div>Hello</div>
    * E.g:
    * tag("<div>", "<p>Hello world</p>", "</div>")
    * returns:
    * "<div><p>Hello world</p></div>"
    */
  def tag(prefix: String, content: String, suffix: String): String = prefix + content + suffix

  /**
    * Then write more specialized versions of it.
    */
  val tagWithDiv = tag("<div>", _,"</div>")

  val tagWithSpan = tag("<span>", _,"</span>")

}
