package variance

trait BoundedMaybe[+A] {
  def isEmpty: Boolean
  def map[B](f: A => B): BoundedMaybe[B] = ???
  def flatMap[B](f: A => BoundedMaybe[B]): BoundedMaybe[B] = ???
  def get: A

  // covariant type A occurs in contravariant position in type => A of value default
  def getOrElse[B >: A](default: B): B = {
    if (isEmpty) default else get
  }
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
  val maybe = Just(3)

  val result = for {
    i <- maybe
  } yield i + 10

  println(s"Result: ${result}")
}