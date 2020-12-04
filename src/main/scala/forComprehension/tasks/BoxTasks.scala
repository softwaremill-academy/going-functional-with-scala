package forComprehension.tasks

object BoxTasks {

  // Let's define a case class Box[Int]
  case class Box(value: Int) {
    def map(f: Int => Int): Box = Box(f(value))

    def flatMap(f: Int => Box): Box = f(value)
  }

  /*
  * Task 1: Using for comprehension take the value out of the Box[Int] type,
  * add 5 to it and return as Box(5).
  */

  def addFive(v1: Box): Box = for {
    val1 <- v1
  } yield val1 + 5


  /*
  * Task 2: Using for comprehension take the values out of the two Box[Int] types,
  * add them together and return in Box.
  */

  def addTwoBoxes(v1: Box, v2: Box): Box =
    for {
      val1 <- v1
      val2 <- v2
    } yield val1 + val2

  /*
  * Task 3: Using for comprehension take the values out of the two Box[Int] types,
  * and add them together if v2 >= 5
  */

  def addTwoBoxesWithFilter(v1: Box, v2: Box): Box =
    for {
      val1 <- v1
      val2 <- v2
    } yield if (val2 >= 5) val1 + val2 else val1

}
