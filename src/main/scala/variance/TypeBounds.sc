sealed trait Maybe[A] {
  def map[B](f: A => B): Maybe[B] = ???
  def flatMap[B](f: A => Maybe[B]): Maybe[B] = ???

  def isDefined: Boolean
  def get: A
}

final case class Full[A](value: A) extends Maybe[A] {
  def isDefined: Boolean = true
  def get = value
}

case object Nil extends Maybe[Nothing] {
  def isDefined = false

  def get = throw new Exception("Nil.get")
}

// Let's define maybe of type Maybe[Int] and assign Nil object

val maybe: Maybe[Int] = Nil
