import scala.util.{Failure, Success, Try}

val x = ()
x

// Try - a wrapper for try/catch
def toInt(s: String): Try[Int] = Try(s.toInt)
toInt("1")
toInt("a")

// pattern matching on Success/Failure
def test(t: Try[Int]): Int =
//  t.map(_ + 1).getOrElse(0)
  t match {
    case Failure(_) => 0
    case Success(value) => value + 1
  }

test(toInt("1"))
test(toInt("a"))

// transform, recover, recoverWith
toInt("a").recover {
  case _: NumberFormatException => 0
}

// Either - a disjunction of any two types
// converting between Try and Either
toInt("1").toEither.left.map(_.getMessage)
toInt("a").toEither.left.map(_.getMessage)

Right(1).asInstanceOf[Either[String, Int]].left

// but the error type doesn't have to be a Throwable - can use a custom error hierarchy
sealed trait Error
case class Error1(message: String) extends Error
case object Error2 extends Error

sealed trait Result

def foo: Either[Error, Result] = ???

// pattern matching on Left/Right
foo match {
  case Left(Error1(message)) | Left(Error2) =>
//  case Left(Error2) => ???
  case Right(value) => ???
//  case _ =>
}
