package typeclassses

case class Person(name: String, email: String)

trait Equal[A] {
  def equal(v1: A, v2: A): Boolean
}

object EmailEquals {
  implicit object EmailEqual extends Equal[Person] {
    def equal(v1: Person, v2: Person): Boolean = v1.email == v2.email
  }
}

object PersonDetailsEquals {
  implicit object PersonDetailsEqual extends Equal[Person] {
    def equal(v1: Person, v2: Person): Boolean =
      v1.name == v2.name && v1.email == v2.email
  }
}

/**
Implement Companion Object with an apply method.
  The method takes two parameters of A and an implicit Equal[A]
  */

object Equals extends App {
  //check your solution here
}

