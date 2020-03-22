import scala.language.higherKinds

trait Monad[F[_]] {
  def pure[A](value: A): F[A]

  def flatMap[A, B](value: A)(f: A => F[B]): F[B]
}

/**
  We all know that every monad is also a Functor.
  Using methods pure() and flatMap() try to implement map method.

  */
