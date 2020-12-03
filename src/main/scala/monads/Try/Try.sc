import scala.util.{Failure, Success, Try}

/* Let's define a function that returns Try */
def toInt(s: String): Try[Int] =
  Try(Integer.parseInt(s.trim))

val t: Try[String] = Try("softwaremill")
val e: Try[String] = Try(throw new Exception("ooops"))

/* Pattern matching examples */

t match {
  case Failure(exception) => s"Error: $exception"
  case Success(value) => value
}

e match {
  case Success(value) => value
  case Failure(exception) => s"Error: $exception"
}
/* Try in for comprehension */

for {
  x <- toInt("1")
  y <- toInt("2")
} yield x + y

for {
  x <- toInt("1")
  y <- toInt("text")
} yield x + y

/* Try's API */

val eitherRight = t.toEither
val eitherLeft = e.toEither

val option = t.toOption
