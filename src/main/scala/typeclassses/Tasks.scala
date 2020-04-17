package typeclassses

case class Person(name: String, email: String)

trait Equal[A] {
  def equal(v1: A, v2: A): Boolean
}

/**
  * Implement implicit objects for comparing Person data. Wrap it in another singleton object.
  */



/**
  * Implement Companion Object with an apply method.
  * The method takes two parameters of A and an implicit Equal[A]
  */

object EqualsTask extends App {
  //check your solution here
}

/**
  * Implement Companion Object with an apply method.
  * The method take only implicit Equal[A]
  */

object ImplicitEqualsTask extends App {
  //check your solution here
}

