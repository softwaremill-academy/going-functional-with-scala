import scala.language.higherKinds

trait Functor[F[_]] {
  def map[A, B](a: F[A])(f: A => B): F[B]
}

object Identity extends App {

  /**
    * Identity
    *
    * F.map(identity) == F
    */

  val identity = (x: Int) => x
  val result = List(1, 2, 3).map(identity) == List(1, 2, 3)

  println(s"Checking Functor Identity: $result")
}

object Associativity extends App {

  /**
    * Associativity
    *
    * F.map(f).map(g) == F.map { f andThen g }
    */

  val f = (x: Int) => x + 1
  val g = (x: Int) => x + 2

  val result = List(1, 2, 3).map(f).map(g) == List(1, 2, 3).map(f andThen g)

  println(s"Checking Functor associativity: $result")
}