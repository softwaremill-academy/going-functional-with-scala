import java.time.{LocalDateTime, ZoneId, ZonedDateTime}
// conversions (primitives, case classes)

//def foo(i: Int) = i + 1
//
//object Helpers {
//  implicit def strToInt(s: String): Int = s.toInt
//}
//
//import Helpers._
//
//foo("1")

//case class Person(firstName: String, lastName: String)
//
//implicit def strToPerson(s: String): Person = {
//  val names = s.split(" ")
//  Person(names(0), names(1))
//}
//
//"Jan Kowalski".firstName

// parameters

def convert(local: LocalDateTime)(implicit tz: ZoneId): ZonedDateTime =
  local.atZone(tz)

object TZ {
  implicit val sydney = ZoneId.of("Australia/Sydney")
}

import TZ.sydney

//implicit val waw = ZoneId.of("Europe/Warsaw")

convert(LocalDateTime.now())

implicit val o: Ordering[Int] = Ordering.fromLessThan((a, b) => b < a)

List(1, 3, 2).sorted

// implicit classes

//implicit class StringSyntax(s: String) {
//  def odwróć = s.reverse
//}
//
//import scala.language.postfixOps
//
//"test" odwróć

