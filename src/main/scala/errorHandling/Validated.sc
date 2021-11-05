import cats.data._
import cats.data.Validated._
import cats.implicits._

import scala.util.Try

sealed abstract class RegistrationError

case object UsernameInvalid extends RegistrationError

case object AgeInvalid extends RegistrationError

case object EmailInvalid extends RegistrationError

case class UserRegistrationError(value: String, errorType: RegistrationError)

case class User(username: String, age: Int, email: String)

type ValidationResult[A] = ValidatedNec[UserRegistrationError, A]

def validateUsername(username: String): ValidationResult[String] = {
  if (username.headOption.exists(_.isUpper))
    username.validNec
  else
    UserRegistrationError(s"Username is empty or does not start with an uppercase character", UsernameInvalid).invalidNec
}


def validateAge(age: String): ValidationResult[Int] = {
  val numericAge = Try(age.toInt)
    .toEither
    .left.map(ex => UserRegistrationError(ex.getMessage, AgeInvalid)).toValidated

  def validateAgeV(x: Int): ValidationResult[Int] = {
//    println("checking age ")
    if (x <= 0 || x > 120)
      UserRegistrationError(s"Age must be between 1-120: $x", AgeInvalid).invalidNec
    else
      x.validNec
  }
//dfasdfasdf
  numericAge.andThen(validateAgeV)
}

def validateEmail(email: String): ValidationResult[String] =
  if (email.isEmpty || !email.contains("@"))
    UserRegistrationError(s"Email address is empty or wrong: $email", EmailInvalid).invalidNec
  else email.validNec

def validateUser(username: String, age: String, email: String): ValidationResult[User] =
  validateUsername(username).andThen(n => validateAge(age).andThen(a => validateEmail(email).map(e => User(n, a, e))))

def validateUser2(name: String): ValidationResult[User] =
  (validateUsername("Bartosz Milewski"), validateAge("600"), validateEmail("bartosz.milewski@gmail.com")).mapN(User)

validateUser("bubu", "foo", "bubu[at]sml.com")
validateUser("Pan bubu", "34", "bubu@sml.com")

validateUser2("bartosz")
