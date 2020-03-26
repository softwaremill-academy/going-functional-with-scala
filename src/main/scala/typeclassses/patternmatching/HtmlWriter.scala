package typeclassses.patternmatching

import java.util.Date

private case class Person(name: String, email: String)

private object HtmlWriter {
  def toHtml(in: Any): String = in match {
    case Person(name, email) => s"<div>$name</div><div>$email</div>"
    case date: Date => s"<div>$date</div>"
    case _ => throw new Exception(s"Can't render $in to HTML")
  }
}

object PatternMatching extends App {
  val personHtml = HtmlWriter.toHtml(Person("John", "john@sml.com"))
  val dateHtml = HtmlWriter.toHtml(new Date())

  println(s"Date: $personHtml")
  println(s"Date: $dateHtml")
}