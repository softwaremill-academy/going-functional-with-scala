val a = Option(1)
val b = Option(2)

a match {
  case Some(x) =>
    b match {
      case Some(y) => x + y
      case None => ???
    }
  case None => ???
}

val result = for {
  x <- a
  y <- b
} yield x + y

case class User(name: String, email: String)

val people = List(User("Tom", "tom@sml.com"), User("Michael", "mike@sml.com"))

for {
  person <- people
} yield person.name

people.map(p => User(p.name.toUpperCase, p.email.toUpperCase))

val listOfLists = List(List(1, 2, 3), List(1, 2, 3, 5))

listOfLists.map(_.map(_ * 3)).flatten

listOfLists.flatMap(xs => xs.map(_ * 3))

for {
  xs <- listOfLists
  x <- xs
} yield x * 3

case class Box[T](value: T) {
  def map[B](f: T => B): Box[B] = Box(f(value))
  def flatMap[B](f: T => Box[B]): Box[B] = f(value)
  def foreach = ???
  def withFilter = ???
}

/**
  * Own type Box
  */

val box1 = Box()
val box2 = Box(" is nice") //Box("sml is nice")

val o = Some("Softwaremill")

for {
  a <- o
} yield a.length

val boxedString = for {
  b1 <- box1 //await f()
  b2 <- box2 //await f2()
} yield b1 + b2

box1.flatMap { b1 =>
  box2.map { b2 =>
    b1 + b2
  }
}

//(b1 => box2.map(b2 => b1.length + b2.length))

List(1, 2, 3).foreach(println) //.map(x => println(s"number: $x"))