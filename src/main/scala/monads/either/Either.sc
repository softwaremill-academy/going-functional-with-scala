def divideBy(what: Int, by: Int): Either[String, Int] =
  if (by == 0) Left("Can't divide by 0") else Right(what / by)

