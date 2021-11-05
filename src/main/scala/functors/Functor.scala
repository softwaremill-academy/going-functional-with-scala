package functors
//Maybe[A] type and two subtypes Full[A] and Empty[A]

trait Maybe[A]

case class Full[A](value: A) extends Maybe[A]
case class Empty[A]() extends Maybe[A]

object Maybe {
  def apply[A](value: A) = if(value == null) Empty[A]() else Full(value)
}

object Functors extends App {}

/**
  * Let's have a Type Constructor C[_] e.g. Option[String]
  * And two types A and B e.g. String and Int
  * We want to create a function that: ( A => B ) => ( C[A] => C[B] )
  */