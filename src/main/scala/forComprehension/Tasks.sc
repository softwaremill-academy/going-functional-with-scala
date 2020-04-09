/**
  * Implement rest of the methods that can be used in for comprehension
  */

case class Box[A](value: A) {
  def map[B](f: A => B): Box[B] = Box(f(value))
  def flatMap[B](f: A => Box[B]): Box[B] = f(value)

  def withFilter = ???
  def foreach = ???
}