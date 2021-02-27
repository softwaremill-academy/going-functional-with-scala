package variance

sealed trait InvariantMaybe[A] {
  def map[B](f: A => B): InvariantMaybe[B] = this match {
    case Just(v) => Just(f(v))
    case Nil() => Nil[B]
  }
  def flatMap[B](f: A => InvariantMaybe[B]): InvariantMaybe[B] = this match {
    case Just(v) => f(v)
    case Nil() => Nil[B]
  }

  def isDefined: Boolean
  def get: A
}

final case class Just[A](value: A) extends InvariantMaybe[A] {
  def isDefined: Boolean = true
  def get = value
}

case class Nil[A]() extends InvariantMaybe[A] {
  def isDefined = false

  def get = throw new NoSuchElementException("Nil.get")
}

object InvariantMaybeApp extends App {
  val maybe = Just(1)

  for {
    i <- maybe
  } yield println(i)
}