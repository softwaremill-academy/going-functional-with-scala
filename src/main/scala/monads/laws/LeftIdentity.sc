
/**
  * Left Identity
  *
  * pure(a).flatMap(func) == func(a)
  *
  */

def func(x: Int): Option[Int] = Some(x + 1)

val optInt = Some(1)

val leftIdentityChecking = Option(1).flatMap(func) == func(1)

println(s"Left identity checking: $leftIdentityChecking")

val resSome = Option(1).flatMap(x => Some(x + 1)) == Some(2)

println(s"Left identity checking with Some: $resSome")

val resNone = Option.empty[Int].flatMap(x => Some(x + 1)) == None

println(s"Left identity checking with None $resNone")

