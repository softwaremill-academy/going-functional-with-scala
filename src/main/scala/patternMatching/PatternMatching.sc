import java.time.LocalDateTime

//Let's define a Visitor
sealed trait Visitor {
  def visitDate: LocalDateTime
}

case class RegisteredUser(id: String,
                          username: String,
                          age: Int,
                          visitDate: LocalDateTime) extends Visitor

case class AnonymousUser(visitDate: LocalDateTime) extends Visitor

val registeredUser = RegisteredUser("1", "joe", 17, LocalDateTime.now())
val anonymousUser = AnonymousUser(LocalDateTime.now())

def findUserById(id: String) = Some(RegisteredUser(id, "joe", 17, LocalDateTime.now().minusDays(1)))

def logUser(user: Visitor) = user match {
  case RegisteredUser(_, username, _, _) ⇒ s"User $username: logged in."
  case AnonymousUser(date) ⇒ s"Anonymous user came at $date."
}

logUser(registeredUser)
logUser(anonymousUser)

//Option, Either examples

val userFromDB: Option[Visitor] = findUserById("1")

val res = userFromDB match {
  case Some(user) ⇒ s"Found user $user"
  case None ⇒ s"No user was found"
}

def monitorJuvenileUsers(user: Visitor) = user match {
  case RegisteredUser(_, username, age, _) if age < 18 ⇒ s"User $username logged in."
  case RegisteredUser(_, _, _, _) ⇒ "Adult user logged in."
  case AnonymousUser(date) ⇒ s"Anonymous user came at $date"
}

trait Department
case object IT extends Department
case object HR extends Department
case object Finance extends Department

def checkDepartment(department: Department) = department match {
  case IT ⇒ "It's IT Department"
  case Finance ⇒ "It's Finance Department"
  case HR ⇒ "It's Human Resources Department"
}

checkDepartment(HR)