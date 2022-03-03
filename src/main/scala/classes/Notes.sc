// Java-like class with val fields in the body
class User {
	val firstName = "John"
	val lastName = "Doe"
	def name = firstName + " " + lastName
}

val john = new User
john.firstName

// move fields to the constructor as non-vals
// then convert constructor params to vals
class User1(val firstName: String, val middleName: String = "mid", val lastName: String) {
	def name = firstName + " " + lastName
}

object User1 {

	def apply(first: String, last: String): User1 = new User1(first, "", last)
}

val john1 = new User1("John", "Doe", "")
val john11 = User1("John", "Doe")


// named parameters
val john2 = new User1("John", lastName = "Doe")

// function-application syntax for objects

// case classes
case class User3(firstName: String, lastName: String)

object User3 {
	def apply(first: String): User3 = User3(first, "Smith")
}

val u = User3("John", "Doe")
val u2 = User3("John")
u.copy(lastName = "Smith")

class A(val x: Int) extends AnyVal
case class B(x: Int)

//def createUser(age: Int, year: Int): Any = ???
//case class Age(i: Int)
//case class Year(i: Int)
//
//def createUser2(age: Age, year: Year): Any = ???
//createUser(39, 1983)
//createUser2(Age(39), Year(1983))

val m = Map(1 -> "x")
m(1)

u == u2

sealed trait Visitor
case class Registered(name: String) extends Visitor
case object Guest extends Visitor

val v: Visitor = Guest
v

