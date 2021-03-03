package transformers

case class ListOptionT[A](value: List[Option[A]]) {
  def map[B](f: A => B): ListOptionT[B] = ListOptionT(value.map(_.map(f)))

  def flatMap[B](f: A => ListOptionT[B]): ListOptionT[B] = ListOptionT(value.flatMap(opt => opt match {
    case Some(a) => f(a).value
    case None => None
  }))
}
