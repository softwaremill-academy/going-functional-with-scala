import scala.util.Random

def matchNumber(n: Any): String = n match {
  case 1 => "one"
  case 2 => "two"
  case x: Int if x > 2 && x < 10 => "between 2 and 10"
  case other => "10 or more"
}

val n = Random.nextInt(20) + 1
matchNumber(n)

case class A(n: Int)

def matchA(a: A): String = a match {
  case A(1) => "got 1"
  case A(other) => s"got $other"
}

matchA(A(1))
matchA(A(3))