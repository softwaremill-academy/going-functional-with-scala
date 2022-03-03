package typeclassses.implicits

trait HtmlWriter[T] {
  def toHtml(value: T): String
}

case class Person(name: String, email: String)

object Person {

  implicit object PersonWriter extends HtmlWriter[Person] {
    override def toHtml(value: Person): String =
      s"<div>${value.name}</div>\n<div>${value.email}</div>"
  }

  /*implicit*/ object PersonWriterWithHiddenEmail extends HtmlWriter[Person] {
    override def toHtml(value: Person): String =
      s"<div>${value.name}</div>\n<div>***</div>"
  }
}

object HtmlWriter {

  def toHtml[T: HtmlWriter](input: T): String = implicitly[HtmlWriter[T]].toHtml(input)

  implicit class HtmlWriterSyntax[T](value: T) {

    def toHtml(implicit writer: HtmlWriter[T]): String = writer.toHtml(value)
  }

  implicit object IntWriter extends HtmlWriter[Int] {
    override def toHtml(value: Int): String = s"<div>number: $value</div>"
  }
}

object Test extends App {
  private val person: Person = Person("Jan Kowalski", "jan@kowalski.com")

  import HtmlWriter.HtmlWriterSyntax

  println(HtmlWriter.toHtml(person))
  println(person.toHtml)
  println(42.toHtml)
}


