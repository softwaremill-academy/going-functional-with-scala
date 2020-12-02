/*
  Let's define a function that tries to convert
  string into Int and returns Option[Int]
*/
def toInt(s: String): Option[Int] =
  try {
    Some(Integer.parseInt(s.trim))
  } catch {
    case _: Exception => None
  }

//Let's define an Option type that can contain a String value
val stringOpt: Option[String] = Some("softwaremill")

val result: Option[Int] = toInt("0")
val empty: Option[Int] = toInt("text")

/* Pattern Matching examples */

result match {
  case Some(value) => s"Value: $value"
  case None => "Cannot get a value"
}

empty match {
  case Some(value) => s"Value: $value"
  case None => "Cannot get a value"
}

/* Option's API */

result.toRight("Error occured")
empty.toLeft(0)

result.getOrElse(0)

/* Option anti patterns */

if (result.isDefined) {
  result.get
}