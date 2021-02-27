package xml

import java.util.Date

trait XmlConverter[T] {
  def xmlify(a: T): String
}

case class User(name: String, email: String)

object Converter {
  def toXml(a: Any) = {
    a match {
      case a: User => s"${a.email}"
      case a: Date => s"${a.getTime}"
      case _ => throw new Error(s"Cannot conver ${a} to XML")
    }
  }
}

// adapter
object Implicits {
  implicit object UserConverter extends XmlConverter[User] {
    def xmlify(a: User): String = s"<user><name>${a.name}</name></user>"
  }

  implicit object HiddenEmailConverter extends XmlConverter[User] {
    def xmlify(a: User): String = s"<user><name>${a.name}</name><email>*****@sm***.com</email></user>"
  }
}

object XMLUtil {
  def xmlify[A](data: A)(implicit converter: XmlConverter[A]) = converter.xmlify(data)
}

object XmlConverter {
  def write[A](data: A)(implicit converter: XmlConverter[A]) = converter.xmlify(data)

  def apply[A](implicit converter: XmlConverter[A]) = converter

  implicit class XmlOps[A](data: A) {
    def toXml(implicit converter: XmlConverter[A]) = converter.xmlify(data)
  }
}

import XmlConverter._

object TemplatesEngine {
  def pageTemplate[A: XmlConverter](data: A): String = {
    println(s"Implicit paramter: ${implicitly[XmlConverter[A]]}")
    s"<users>\n   ${data.toXml}\n</users>"
  }
}

object XmlApp extends App {

  import xml.Implicits.HiddenEmailConverter

//  UserConverter.xmlify(User("bubu", "bubu@sml.com"))

  XMLUtil.xmlify(User("bubu", "bubu@sml.com"))

  XmlConverter.write(User("bubu", "bubu@sml.com"))

  XmlConverter[User].xmlify(User("bubu", "bubu@sml.com"))

  import XmlConverter._
  println(User("bubu", "bubu@sml.com").toXml)

  println(TemplatesEngine.pageTemplate(User("bubu", "bubu@sml.com")))
}





































//trait XmlConverter[T] {
//  def xmlify(a: T): String
//}
//
//case class Movie(name: String, year: Int, rating: Double)
//
//object XmlConverters {
//
//  implicit object MovieConverter extends XmlConverter[Movie] {
//    def xmlify(a: Movie): String = s"<movie><name>${a.name}</name><year>${a.year}</year><rating>${a.rating}</rating"
//  }
//
//}
//
//object XmlUtil {
//  def xmlify[A](a: A)(implicit converter: XmlConverter[A]) = converter.xmlify(a)
//}
//
//object XmlConverter {
//  def write[A](in: A)(implicit converter: XmlConverter[A]): String = converter.xmlify(in)
//
//  def apply[A](implicit converter: XmlConverter[A]) = converter
//
//  implicit class XmlOps[T](data: T) {
//    def toXml(implicit converter: XmlConverter[T]) = converter.xmlify(data)
//  }
//}
//
//import XmlConverter._
//
//object XmlTemplates {
//  def pageTemplate[A: XmlConverter](body: A): String = {
//     s"${body.toXml}"
//  }
//}
//object XmlApp extends App {
//
//  import XmlConverters._
//  import XmlTemplates._
//  XmlUtil.xmlify(Movie("Incepcja", 2000, 10))
//
//  XmlConverter[Movie].xmlify(Movie("Titanic", 1997, 9))
//
//  println(Movie("Titanic", 1997, 9).toXml)
//  println(pageTemplate(Movie("Rambo", 1982, 8)))
//}
