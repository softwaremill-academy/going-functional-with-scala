import java.time.LocalDateTime
import java.time.LocalDateTime._

sealed trait Status {
  def since: LocalDateTime
}

case class Active(since: LocalDateTime) extends Status

case class Blocked(since: LocalDateTime, reason: String) extends Status

case class Inactive(since: LocalDateTime) extends Status

def process(status: Status): Unit = status match {
  case Active(since) if since.isBefore(now().minusWeeks(1)) => println("Active, older than a week")

  case s: Status if s.since.isBefore(now().minusMonths(1)) => println("Any older than a month")

  case s @ Blocked(_, "unknown") => println(s"Blocked for an unknown reason: $s")

  case Blocked(_, "foo" | "bar") => println("Blocked because foo or bar")

  case _: Active => println("Just active")


  case _: Blocked => println("Just blocked")
  case other => println(s"other: $other") // comment out for a non-exhaustive match warning
}

process(Blocked(LocalDateTime.now(), "foo"))
process(Blocked(LocalDateTime.now(), "bar"))
process(Blocked(LocalDateTime.now(), "baz"))