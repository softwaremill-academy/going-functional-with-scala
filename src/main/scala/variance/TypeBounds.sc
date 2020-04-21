sealed trait Maybe[+A] {
  def map[B](f: A => B): Maybe[B] = ???
  def flatMap[B](f: A => Maybe[B]): Maybe[B] = ???

  def isDefined: Boolean
  def get: A
  def getOrElse[AA >: A](default: AA): AA = if(isDefined) get else default
}

final case class Full[A](value: A) extends Maybe[A] {
  def isDefined: Boolean = true
  def get = value
}

case object Nil extends Maybe[Nothing] {
  def isDefined = false

  def get = throw new Exception("Nil.get")
}

val maybe: Maybe[Int] = Nil

maybe.getOrElse(0)
