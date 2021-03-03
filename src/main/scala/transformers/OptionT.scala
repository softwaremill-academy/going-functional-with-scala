package transformers

case class OptionT[M[_], A](value: M[Option[A]]) {
  def map[B](f: A => B)(implicit fa: Functor[M]): OptionT[M, B] = OptionT(fa.map(value)(_.map(f)))

  def flatMap[B](f: A => OptionT[M, B])(implicit ma: Monad[M]): OptionT[M, B] = OptionT(ma.flatMap(value) {
    case Some(a) => f(a).value
    case None => ma.lift(None)
  })
}
