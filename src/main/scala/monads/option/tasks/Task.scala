package monads.option.tasks

object Task {

  /*
 * Task 1: Using flatMap and map,
 * write a method addOpts that accepts two Option parameters of type Option[Int] and adds them together.
 */

  def addOptsWithFlatMap(optValue1: Option[Int], optValue2: Option[Int]): Option[Int] =
    optValue1.flatMap(value1 => optValue2.map(value2 => value1 + value2))


  /*
  * Task 2: Using flatMap and map
  * extend the previous method to accept three Option parameters of type Option[Int].
  */

  def addThreeOptsWithFlatMap(optValue1: Option[Int], optValue2: Option[Int], optValue3: Option[Int]) =
    optValue1.flatMap(val1 => optValue2.flatMap(val2 => optValue3.map(val3 => val1 + val2 + val3)))

  /*
  * Task 3: Using flatMap and map,
  * add to Option values together only if both are bigger than 5 otherwise return None
  */

  def addTwoOptsWithFlatMapAndFilter(optValue1: Option[Int], optValue2: Option[Int]) = {
    val condition: Int => Boolean = _ > 5
    optValue1.filter(condition).flatMap(val1 => optValue2.filter(condition).map(val2 => val1 + val2))
  }

}
