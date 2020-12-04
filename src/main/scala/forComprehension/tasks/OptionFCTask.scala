package forComprehension.tasks

object OptionFCTask {

  /*
  * Task 1: Using for comprehension,
  * write a method addOpts that accepts two Option parameters of type Option[Int] and adds them together.
  */

  def addTwoOpts(optValue1: Option[Int], optValue2: Option[Int]) =
    for {
      val1 <- optValue1
      val2 <- optValue2
    } yield val1 + val2

  /*
    * Task 2: Using for comprehension
    * extend the previous method to accept three Option parameters of type Option[Int].
    */

  def addThreeOpts(optValue1: Option[Int], optValue2: Option[Int], optValue3: Option[Int]) =
    for {
      val1 <- optValue1
      val2 <- optValue2
      val3 <- optValue3
    } yield val1 + val2 + val3

  /*
  * Task 3: Using for comprehension
  * add to Option values together only if both are bigger than 5 otherwise return None
  */

  def addTwoOptsWithFilter(optValue1: Option[Int], optValue2: Option[Int]) =
    for {
      val1 <- optValue1
      if val1 > 5
      val2 <- optValue2
      if val2 > 5
    } yield val1 + val2
}
