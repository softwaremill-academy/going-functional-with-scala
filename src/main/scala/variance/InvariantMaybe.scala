package variance

sealed trait InvariantMaybe[A] {
  def map[B](f: A => B): InvariantMaybe[B] = ???

  def flatMap[B](f: A => InvariantMaybe[B]): InvariantMaybe[B] = ???

  def isDefined: Boolean

  def get: A
}

object InvariantMaybeApp extends App {
}