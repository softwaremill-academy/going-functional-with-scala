package monads

import scala.language.higherKinds

trait Monad[F[_]] {
  def pure[A](value: A): F[A]

  def flatMap[A, B](value: F[A])(f: A => F[B]): F[B]
}

object Laws extends App {
  def throwsException = throw new Exception("oops")

  /**
    * Left Identity

    * pure(a).flatMap(func) == func(a)

    */

  def func(x: Int): Option[Int] = Some(x + 1)

  val optInt = Some(1)

  val leftIdentityChecking = Option.apply(1).flatMap(func) == func(1)

  println(s"Left identity checking: $leftIdentityChecking")

  val resSome = Option.apply(1).flatMap(x => Some(x + 1)) == Some(2)

  println(s"Left identity checking with Some: $resSome")

  val resNone = Option.empty[Int].flatMap(x => Some(x + 1)) == None

  println(s"Left identity checking with None $resNone")

  /**
    * Right Identity

    * m.flatMap(pure) == m

    */

  val rightIdentityChecking = optInt.flatMap(Option.apply) == optInt

  println(s"Right identity checking: $rightIdentityChecking")

  /**
    * Associativity

    * m.flatMap(f).flatMap(g) == m.flatMap(x => f(x).flatMap(g))

    */

  //Does it break Left Identity?

  //Option.apply(1).flatMap(throwsException) == throwsException
}
