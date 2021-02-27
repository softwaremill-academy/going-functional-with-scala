package variance

// How to make a type covariant?
sealed trait CovariantMaybe[A] {
  def map[B](f: A => B): CovariantMaybe[B] = ???

  def flatMap[B](f: A => CovariantMaybe[B]) = ???
}

object CovariantMaybeApp extends App {
}