package patternMatching

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
