package m2.patternMatching

import java.time.LocalDateTime

class Ex1_PatternMatching {

  /**
    * Using Pattern matching check if a number is even
    */

  def isEven(num: Int): Boolean = num match {
    case n if n % 2 == 0 => true
    case _ => false
  }

  /**
    * Implement a method isEmailCorrect that checks whether a given user has a valid email address.
    * User Pattern Matching
    */

  trait Visitor {
    def visitDate: LocalDateTime
  }

  case class RegisteredUser(id: String,
                            username: String,
                            email: String,
                            age: Int,
                            visitDate: LocalDateTime) extends Visitor

  case class AnonymousUser(visitDate: LocalDateTime) extends Visitor

  def isEmailCorrect(user: Visitor): Boolean = user match {
    case RegisteredUser(_, _, email, _, _) => """(\w+)@([\w\.]+)""".r.unapplySeq(email).isDefined
    case AnonymousUser(_) => false
  }

  /**
    * Implement a method that takes a List[Int] and adds two first elements together
    */

  def addTwoElements(numbers: List[Int]): Int =  numbers match {
    case List(a, b, _*) => a + b
    case List(a, b) => a + b
    case List(a) => a
    case _  => 0
  }

  /**
    * Using Pattern Matching add two int Options together. Remember about None values.
    */

  def addTwoIntOptions(a: Option[Int], b: Option[Int]): Option[Int] = (a, b) match {
    case (Some(x), Some(y)) => Some(x + y)
    case (Some(x), None) => Some(x)
    case (None, Some(y)) => Some(y)
    case (None, None) => None
  }

}
