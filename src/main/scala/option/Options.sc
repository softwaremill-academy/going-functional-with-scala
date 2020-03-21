//Let's define an Option type that can contain a String value

val stringOpt: Option[String] = Some("string_value")

//and toInt function that returns Option[Int]

def toInt(s: String): Option[Int] =
  try {
    Some(Integer.parseInt(s.trim))
  } catch {
    case _: Exception => None
  }