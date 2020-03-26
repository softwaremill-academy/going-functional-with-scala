import scala.util.{Try, Success, Failure}
//Available since Scala 2.10. Returns failure information rather than None

def divide(what: Int, by: Int) = Try(what / by)

val res = divide(10, 2)

res match {
  case Success(value) => value
  case Failure(e) => println(s"Failed, message is: $e")
}

val z = for {
  x <- divide(10, 2)
  y <- divide(20, 4)
} yield x * y
