case class Key(name: String)

object Key {

//  def unapply(input: String): Option[String] = if (input.contains(" ")) None else Some(input)
}

case class KeyValue(key: Key, value: String)

object KeyValue {

  def unapply(input: String): Option[(String, String)] =
    input.split(":") match {
      case Array(key, value) => Some((key, value))
      case _ => None
    }

  def unapply(i: Any): Option[(Key, String)] = ???
}

val KeyValue(k, v) = "foo:bar"

def extract(s: Any): Unit = s match {
  case KeyValue(key, value) /*if key.nonEmpty && value.nonEmpty*/ => println(s"key: $key, value: $value")
  case _ => println("invalid")
}

KeyValue.unapply("a c:b")

//extract("x:7")
extract("an swer:42")
//extract(":2")
//extract("x7")
//extract("")
