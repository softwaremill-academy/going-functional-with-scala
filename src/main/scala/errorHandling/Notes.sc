import cats.data.EitherT
import cats.implicits.catsSyntaxEitherId

import scala.util.Try

// Try - a wrapper for try/catch
def toInt(s: String): Try[Int] = ???

// pattern matching on Success/Failure

// transform, recover, recoverWith

// Either - a disjunction of any two types
def toIntEither(s: String): Either[Throwable, Int] = toInt(s).toEither

// but the error type doesn't have to be a Throwable - can use a custom error hierarchy

// pattern matching on Left/Right

// converting between Try and Either
