// Java-like class with val fields in the body
class User(val firstName: String = "John", val lastName: String = "Doe") {
	def name = firstName + " " + lastName

	def withName(name: String): User = new User(name, this.lastName)
}

(new User(lastName = "Smith")).toString

// move fields to the constructor as non-vals
// then convert constructor params to vals

// named parameters

// function-application syntax for objects
class Adder(n: Int) {
	def apply(i: Int) = n + i
}
val adder = new Adder(2)
adder(2)

// companion objects, apply
object User {
	val Const = "foo"

	def apply(s: String): User = ???
}

User.Const
User("aa")

// case classes
/*case */class User2(val firstName: String, val lastName: String)

object User2 {
	def apply(str: String, str1: String): User2 = User2(str, str1)
	def unapply(u: User2): Option[(String, String)] = Some((u.firstName, u.lastName))
}

val u = User2("John", "Smith")
val (first, last) = User2.unapply(u).get
val User2(first, last) = u

case object Test

