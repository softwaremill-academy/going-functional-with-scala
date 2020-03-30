package monads

trait Maybe[A]

case class Full[A](value: A) extends Maybe[A]
case class Empty[A]() extends Maybe[A]

object Monads extends App {

  val maybe = Full("softwaremill")

  val strLength = for {
    s <- maybe
  } yield s.length

  println(s"String length is: $strLength")
}