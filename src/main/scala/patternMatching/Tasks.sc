import java.time.LocalDateTime

/**
  * Using Pattern matching check if a number is even
  */

def isEven(num: Int): Boolean = num match {
  case x if x % 2 == 0 => true
  case _ => false
}

/**
  * Implement a method isEmailCorrect that checks whether a given user has an email address.
  * Use Pattern Matching
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

def isEmailCorrect(user: Visitor): Boolean = user match {
  case RegisteredUser(_, _, email, _, _) if !email.isEmpty => true
  case _ => false
}

/**
  * Using Pattern matching implement a method that takes a List[Int] and adds two first elements together
  */

def addTwoElements(numbers: List[Int]): Int = numbers match {
  case List(a, b) => a + b
  case List(a) => a
  case _ => 0
}

addTwoElements(List(1, 2, 3, 4))
addTwoElements(List(1))
addTwoElements(List(1, 2))
addTwoElements(List())

/**
  * Using Pattern Matching add two int Options together. Remember about None values.
  */

