import scala.util.{Failure, Success, Try}
//Let's define a function

def toInt(s: String): Try[Int] =
  Try(Integer.parseInt(s.trim))

// Some(_) or None

trait Error
case object UserError extends Error
case object EmailError extends Error

//Either[_, _] => Left(_) i Right(_)
val either: Either[Error, Int] = Right(1)

for {
  i <- either
} yield i + 1

val t: Try[Int] = Try(1)

t match {
  case Failure(exception) => println(s"$exception")
  case Success(value) => println(s"$value")
}

def foo(a: Int) = throw new Exception("oops")
Try(1).flatMap(foo) == foo(1)

