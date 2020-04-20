package application

case class Person(name: String, email: String)

object Person {
  implicit object PersonWriter extends HtmlWriter[Person] {
    def toHtml(in: Person): String = s"<div>${in.name}</div>\n<div>${in.email}</div>"
  }

}
