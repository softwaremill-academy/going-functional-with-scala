package transformers

case class EitherT[M[_], E, A](value: M[Either[E, A]]) {
  def map[C](f: A => C)(implicit fa: Functor[M]): EitherT[M, E, C] = EitherT(fa.map(value)(_.map(f)))

  def flatMap[C](f: A => EitherT[M, E, C])(implicit ma: Monad[M]): EitherT[M, E, C] = EitherT(ma.flatMap(value) {
    case Right(a) => f(a).value
    case l @ Left(_) => ma.lift(l.asInstanceOf[Either[E, C]])
  })
}
