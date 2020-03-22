import scala.util.Try

sealed abstract class RegistrationError

case object UsernameMustBeUnique extends RegistrationError

case object UsernameMustBeUppercase extends RegistrationError

case object UsernameMustHaveLengthFive extends RegistrationError

case object AgeInvalid extends RegistrationError

case object EmailInvalid extends RegistrationError

case class UserRegistrationError(value: String, errorType: RegistrationError)

case class User(username: String, age: Int, email: String)

type ValidationResult[A] = Either[UserRegistrationError, A]

def validateUsername(username: String): ValidationResult[String] = {
  if (username.headOption.exists(_.isUpper))
    Right(username)
  else
    Left(UserRegistrationError(s"Username is empty or does not start with an uppercase character", UsernameMustBeUppercase))
}

def validateAge(age: String): ValidationResult[Int] = for {
  numericAge <- Try(age.toInt).toEither.left.map(ex => UserRegistrationError(ex.getMessage, AgeInvalid))
  validAge <- {
    if (numericAge <= 0 || numericAge > 120)
      Left(UserRegistrationError(s"Age must a number between 1-120: $numericAge", AgeInvalid))
    else
      Right(numericAge)
  }
} yield validAge

def validateEmail(email: String): ValidationResult[String] =
  if (email.isEmpty || !email.contains("@"))
    Left(UserRegistrationError(s"Email address is empty or wrong: $email", EmailInvalid))
  else Right(email)

def validateUser(username: String, age: String, email: String): ValidationResult[User] = for {
  validUsername <- validateUsername(username)
  validAge <- validateAge(age)
  validEmail <- validateEmail(email)
} yield User(validUsername, validAge, validEmail)

validateUser("bubu", "foo", "bubu[at]sml.com")
validateUser("Pan bubu", "34", "bubu@sml.com")

