// basic definition
def hello(firstName: String, lastName: String, age: Int = 42): String =
  s"Hello $firstName $lastName ($age)"

hello("Jacek", "Kunicki", 39)
hello("Jacek", age = 39, lastName = "Kunicki")
hello("Jacek", "Kunicki")

class User

def testUser(firstName: String = "John", lastName: String = "Smith", age: Int = 42): User = ???
testUser(age = 18)
//
// named parameters

// default parameter values

// by-name parameters
def foo: String = {
  println("foo")
  "test"
}

def byName(s: => String): Boolean = {
  s == "test"
  s == "test"
}
byName(foo)

// varargs + sequences as vararg
def sum(ints: Int*) = ints.sum
sum(1: Int, 2, 3)
sum(Seq(1, 2, 3): _*)

// function composition
val f: Int => Int = _ + 1
val g: Int => Int = _ * 2

g(f(2))
val composed = f.andThen(g)
composed(2)
f.compose(g)(2)

// eta-expansion
def h(i: Int): Int = i - 2
val hh: Int => Int = h
hh

f.andThen(h)(2)
(h _).andThen(f) /*(2)*/

// currying
// Int => Int => Int
def add(a: Int, b: Int) = a + b
(add _)
add(2, _)
(add _).curried

add(2, 3)

def add2(a: Int)(b: Int) = a + b
(add2 _)
var add3: Int => Int = add2(3)
add3 = add2(4)
add3(7)

// multiple parameter lists -> type inference
// void <A> x(A a, Function<A, Integer> f)
def x[A](a: A, f: A => Int) = ???
x(1, i => {
  i + 1
})

def y[A](a: A)(f: A => Int) = ???
y(1) { i =>
  i + 1
  //
}


// partially applied functions
def z(a: Int, b: Int, c: Int) = a + b + c
(z _).curried
(z _).curried(1)
(z _).curried(1)(2)

(z _)
z(1, _, _)
z(1, 2, _)
//
//def add1And3 = z(1, _, _)
//add1And3(2, 3)

// partial functions (collect, error handling)
def divide: PartialFunction[Int, Int] = {
  case x if x != 0 => 10 / x
}
divide(0) // Int => Int

List(1, 2, 3).filter(_ % 2 == 0).map(_ + 5)
List(1, 2, 3).collect {
  case x if x % 2 == 0 => x + 5
}




// exercise - partially applied and partial functions