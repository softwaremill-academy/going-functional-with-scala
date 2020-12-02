package typeclassses.inheritance

trait HtmlWriter {
  def toHtml: HTML
}

case class Person(name: String, email: String) extends HtmlWriter {
  def toHtml: HTML = s"<div>$name</div>\n<div>$email</div>"
}

object InheritanceApproach extends App {
  val person = Person("John", "john@sml.com")
  println(person.toHtml)
}