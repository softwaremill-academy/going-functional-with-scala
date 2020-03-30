//Traits

trait Human {
  def name: String = "I'm Human"
}

trait Robot {
  def name: String = "I'm Robot"
}

case class Person() extends Robot with Human {
  override def name: String = super.name
}

case class Robocop() extends Human with Robot {
  override def name: String = super.name
}

val person = Person()
person.name

val robocop = Robocop()
robocop.name