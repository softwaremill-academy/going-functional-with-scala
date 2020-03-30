val option = Some("string")

option.flatMap(s => Some(s.length))

option.flatMap { s =>
  Some(s.length)
}

option.map(s => s.length)

option.map { s =>
  s.length
}

trait Person {
  def name: String
  def age: Int

  override def toString: String = s"Person($name, $age)"
}

val mary = new Person {
  val name = "Mary"
  val age = 35
}

print(mary)

case class StringToInt(run: String => Int)

val stringToInt = StringToInt { s => s.length }.run("softwaremill")