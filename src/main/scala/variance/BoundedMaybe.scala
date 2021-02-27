package variance

trait BoundedMaybe[+A] {
}

final case class Just[A](value: A) extends BoundedMaybe[A] {
  def isEmpty: Boolean = false
  def get = value
}

case object Nil extends BoundedMaybe[Nothing] {
  def isEmpty = true
  def get = throw new NoSuchElementException("Nil.get")
}

object BoundedMaybeApp extends App {
}