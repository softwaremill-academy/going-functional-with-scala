/* Let's define a function that takes two number */
def divideBy(what: Int, by: Int): Either[String, Int] =
  if (by == 0) Left("Can't divide by 0") else Right(what / by)

/* Let's define some Eithers */
val rightResult: Either[String, Int] = divideBy(10, 2)
val leftResult: Either[String, Int] = divideBy(10, 0)

/* Pattern matching examples */
rightResult match {
    case Right(x) => x
    case Left(s) =>  s
}

leftResult match {
    case Right(x) => x
    case Left(s) => s
}

/* Either's API */

// transforming to Option[Int]
val option: Option[Int] = rightResult.toOption

// transforming to Seq[Int]
val seq: Seq[Int] = rightResult.toSeq

// swapping sides
val swappedEither: Either[Int, String] = rightResult.swap


