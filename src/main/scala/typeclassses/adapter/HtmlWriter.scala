package typeclassses.adapter

trait HtmlWriter[T] {
  def toHtml(in: T): String
}

case class Person(name: String, email: String)

object PersonWriter extends HtmlWriter[Person] {
  def toHtml(in: Person): String = s"<div>${in.name}</div>\n<div>${in.email}</div>"
}

object Adapter extends App {
  val person = Person("", "krzysiek@sml.com")
  println(PersonWriter.toHtml(person))
}
