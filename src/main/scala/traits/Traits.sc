//Traits

trait Human {
  def name: String = "I'm Human"
}

trait Robot {
  def name: String = "I'm Robot"
}

case class PersonOrRobot() extends Robot with Human {
  override def name: String = super.name
}

case class RobotOrPerson() extends Human with Robot {
  override def name: String = super.name
}

val person = PersonOrRobot()
person.name //I'm human

val robocop = RobotOrPerson()
robocop.name //I'm robot