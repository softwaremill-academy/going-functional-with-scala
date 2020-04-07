sealed trait Maybe[A] {
  def map[B](f: A => B): Maybe[B] = ???
  def flatMap[B](f: A => Maybe[B]): Maybe[B] = ???

  def isEmpty: Boolean
  def get: A
  def getOrElse[B >: A](default: B): B = if(isEmpty) default else get
}

final case class Full[A](value: A) extends Maybe[A] {
  def isEmpty: Boolean = false
  def get = value
}

object Nil extends Maybe[Nothing] {
  def isEmpty = true

  def get = throw new Exception("Nil.get")
}

val maybe: Maybe[Int] = Nil