package implicits.tasks

object TaskTwo {

  /**
    * Use your previous implicit class and change it. Your new implicit class should:
    * - have fuckYeah method that return as many "fuckYeah"'s as the value
    * - times method that takes a function parameter Int => String
    * - method fuckYeah should use times method
    */

  implicit class NewClass(value: Int) {
    def fuckYeah: Seq[String] = times(_ => "fuckYeah")

    def times(f: Int => String): Seq[String] = {
      for (i <- 0 until value) yield f(i)
    }
  }

}
