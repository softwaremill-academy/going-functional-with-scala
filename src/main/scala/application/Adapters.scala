package application

import typeclassses.adapter.{HtmlWriter, Person}

object Adapters {
  implicit object HiddenEmailPersonWriter extends HtmlWriter[Person] {
    def toHtml(in: Person): String = s"<div>${in.name}</div>\n<div>****@****</div>"
  }
}
