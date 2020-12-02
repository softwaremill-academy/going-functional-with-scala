
/**
  * Associativity
  *
  * m.flatMap(f).flatMap(g) == m.flatMap(x => f(x).flatMap(g))
  *
  */

val optInt = Some(1)

val f: Int => Option[Int] = x => Some(x + 1)
val g: Int => Option[Int] = x => Some(x + 10)

val associativity = optInt.flatMap(f).flatMap(g) == optInt.flatMap(f(_).flatMap(g))

println(s"Associativity: $associativity")
