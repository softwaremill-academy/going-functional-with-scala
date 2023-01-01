// stackability - order matters
trait Human {
  def name: String = "I'm Human"
}

trait Robot {
  def name: String = "I'm Robot"
}

abstract class Animal(x: String) {
  def name = "I'm an animal"
}


class PersonOrRobot extends Animal("dd") with Robot {
  override def name = super.name
}

class RobotOrPerson extends Robot with Human {
  override def name = super.name
}

(new PersonOrRobot).name
(new RobotOrPerson).name

// selective mixins - only to specific class instances
class Test
val t1 = new Test
//t1.name
val t2 = new Test with Robot
t2.name

// self types
trait A {
  def foo: String = ???
}

trait B { self: A =>
//  self.
}

trait C extends B with A

def test(x: {def name: String})
