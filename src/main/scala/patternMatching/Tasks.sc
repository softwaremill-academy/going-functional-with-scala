import java.time.LocalDateTime

/**
  * Using Pattern matching check if a number is even
  */

def isEven(num: Int): Boolean = ???

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

val registeredUser = RegisteredUser("1", "joe", "joe@gmail.com", 17, LocalDateTime.now())
val anonymousUser = AnonymousUser(LocalDateTime.now())

def isEmailCorrect(user: Visitor): Boolean = ???

/**
  * Implement a method that takes a List[Int] and adds two first elements together
  */

def addTwoElements(numbers: List[Int]): Int = ???

addTwoElements(List(1, 2, 3, 4)) // 3
addTwoElements(List(1)) // 1
addTwoElements(List(1, 2)) // 3
addTwoElements(List()) // 0

/**
  * Using Pattern Matching add two int Options together. Remember about None values.
  */

val a = Some(1)
val b = Some(2)

def sumOptions(a: Option[Int], b: Option[Int]): Option[Int] = ???

sumOptions(a, b) // Some(3)
sumOptions(None, b) // None
sumOptions(a, None) // None
sumOptions(None, None) // None


