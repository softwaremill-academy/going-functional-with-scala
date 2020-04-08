package typeclassses.implicits

case class Person(name: String, email: String)

//Adapter pattern

trait HtmlWriter[T] {
  def toHtml(value: T): String
}

object PersonWriter extends HtmlWriter[Person] {
  def toHtml(value: Person): String = s"<div>${value.name}</div>\n<div>${value.email}"
}

//Adding implicits

object HtmlUtil {
  def htmlify[A](data: A)(implicit writer: HtmlWriter[A]): String = writer.toHtml(data)
}

object Application extends App {
  //define in implicit scope
  implicit object PersonWriter extends HtmlWriter[Person] {
    def toHtml(value: Person): String = s"<div>Name: ${value.name}</div>\n<div>Email: ${value.email}</div>"
  }

  val personHtml = HtmlUtil.htmlify(Person("John", "john@sml.com"))
  println(personHtml)
}

//Interfaces using implicit parameters

object HtmlWriter {
  //def toHtml[A](value: A)(implicit writer: HtmlWriter[A]): String = writer.toHtml(value)
  def apply[A](implicit writer: HtmlWriter[A]): HtmlWriter[A] = writer
}

object Application2 extends App {
  implicit object PersonWriter extends HtmlWriter[Person] {
    def toHtml(value: Person): String = s"<div>Name: ${value.name}</div>\n<div>Email: ${value.email}</div>"
  }

  val personHtml = HtmlWriter[Person].toHtml(Person("John", "john@sml.com"))
  println(personHtml)

  val x = List.empty[Int].collect {
    case y => y + 1
  }

  println(s"x: $x")
}
