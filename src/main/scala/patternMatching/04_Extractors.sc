case class Key(name: String)

object Key {

  def unapply(input: String): Option[String] = if (input.contains(" ")) None else Some(input)
}

case class KeyValue(key: Key, value: String)

object KeyValue {

  def unapply(input: String): Option[(String, String)] =
    input.split(":") match {
      case Array(key, value) => Some((key, value))
      case _ => None
    }
}

val KeyValue(k, v) = "foo:bar"

def extract(s: String): Unit = s match {
  case KeyValue(Key(key), value) if key.nonEmpty && value.nonEmpty => println(s"key: $key, value: $value")
  case _ => println("invalid")
}

extract("x:7")
extract("answer:42")
extract(":2")
extract("x7")
extract("")
