package transformers

trait Monad[M[_]] extends Functor[M]{
  def flatMap[A, B](ma: M[A])(f: A => M[B]): M[B]

  def lift[A](a: A): M[A]
}
