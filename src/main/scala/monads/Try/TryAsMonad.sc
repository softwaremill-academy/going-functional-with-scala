import scala.util.Try

def throwsException(x: Int) = throw new Exception("oops")

/**
  * Left Identity
  *
  * Try(1).flatMap(throwsException) == throwsException(a)
  *
  */


/**
  * Does Try break Left Identity?
  */

val tryResult = Try(1).flatMap(throwsException)
