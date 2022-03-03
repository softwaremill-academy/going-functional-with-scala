import scala.util.{Failure, Success, Try}

def divide(a: Int, b: Int) = Try(a / b)

def divide2(a: Int, b: Int) = try {
  a / b
} catch {
  case e: ArithmeticException => println("")
}

//divide(10, 2) match {
//  case Failure(exception) => println(s"error: ${exception.getMessage}")
//  case Success(value) => println(s"value: $value")
//}
divide(10, 2).toOption
divide(10, 2).toEither match {
  case Left(value) => ???
  case Right(value) => ???
}

divide(10, 0).toOption
divide(10, 0).toEither

