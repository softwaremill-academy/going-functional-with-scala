package typeclassses.inheritance

trait HtmlWriter {
  def toHtml: String
}

case class Person(name: String, email: String) extends HtmlWriter {
  def toHtml: String = s"<div>$name</div>\n<div>$email</div>"
}

object InheritanceApproach extends App {
  val person = Person("John", "john@sml.com")
  println(person.toHtml)
}