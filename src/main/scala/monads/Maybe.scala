package monads

trait Maybe[A] {
  // write some code here
}

case class Full[A](value: A) extends Maybe[A]
case class Empty[A]() extends Maybe[A]
