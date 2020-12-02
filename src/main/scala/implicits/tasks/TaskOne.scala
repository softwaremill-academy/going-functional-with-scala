package implicits.tasks

object TaskOne {

  /**
    * Make this class an implicit class that takes an int value `i` and has `fuckYeah` method returns "fuckYeah" i times.
    */

  implicit class TaskToBeImplicit(value: Int) {
    def fuckYeah(): Seq[String] = {
      for(_ <- 0 until value) yield "fuckYeah"
    }
  }

}
