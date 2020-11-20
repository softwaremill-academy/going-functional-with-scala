
/**
  * Right Identity
  *
  * m.flatMap(pure) == m
  *
  */

val optInt = Some(1)

val rightIdentityChecking = optInt.flatMap(Option.apply) == optInt

println(s"Right identity checking: $rightIdentityChecking")
