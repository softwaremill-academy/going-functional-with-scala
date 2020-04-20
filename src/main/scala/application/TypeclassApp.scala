package application

import HtmlWriter._

object Templates {
  def pageTemplate[T: HtmlWriter](body: T): String = {
    s"<html><body>${body.toHtml}</body></html>"
  }
}
object TypeclassApp extends App {

  val person = Person("John", "john@sml.com")

  import Adapters.HiddenEmailPersonWriter
//  println(HtmlWriter[Person].toHtml(person))

  println(s"Person: ${person.toHtml}")

  import Templates._

  println(pageTemplate(person))
}
