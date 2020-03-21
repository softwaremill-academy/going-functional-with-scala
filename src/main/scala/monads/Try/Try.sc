import scala.util.Try
//Let's define a function

def toInt(s: String): Try[Int] =
  Try(Integer.parseInt(s.trim))
