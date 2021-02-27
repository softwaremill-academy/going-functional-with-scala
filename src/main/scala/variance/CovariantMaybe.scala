package variance

sealed trait CovariantMaybe[+A] {
  def map[B](f: A => B): CovariantMaybe[B] = this match {
    case Just(v) => Just(f(v))
    case Nil => Nil
  }

  def flatMap[B](f: A => CovariantMaybe[B]) = this match {
    case Just(v) => f(v)
    case Nil => Nil
  }
}

final case class Just[A](v: A) extends CovariantMaybe[A] {
  def isEmpty = false
  def get = v
}

final case object Nil extends CovariantMaybe[Nothing] {
  def isEmpty = true
  def get = throw new NoSuchElementException("Nil.get")
}

object CovariantMaybeApp extends App {
  val maybe: CovariantMaybe[Int] = Nil

  val result = for {
    i <- maybe
  } yield i + 1

  println(result)
}