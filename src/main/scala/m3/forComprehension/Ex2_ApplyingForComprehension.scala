package m3.forComprehension

class Ex2_ApplyingForComprehension {

  // Let's define a case class Box[Int]
  case class Box(value: Int) {
    def map(f: Int => Int): Box = Box(f(value))
    def flatMap(f: Int => Box): Box = f(value)
    def withFilter(f: Int => Boolean): Box = if (f(value)) Box(value) else Box(0)
  }

  /*
  * Task 1: Using for comprehension take the value out of the Box[Int] type,
  * add 5 to it and return as Box(5).
  */

  def addFive(v1: Box): Box = for {
    v <- v1
  } yield v + 5

  /*
  * Task 2: Using for comprehension take the values out of the two Box[Int] types,
  * add them together and return in Box.
  */

  def addTwoBoxes(v1: Box, v2: Box): Box = for {
    a <- v1
    b <- v2
  } yield a + b

  /*
  * Task 3: Using for comprehension take the values out of the two Box[Int] types,
  * and add them together if v2 >= 5
  */

  def addTwoBoxesWithFilter(v1: Box, v2: Box): Box = for {
    a <- v1
    b <- v2
    if b >= 5
  } yield a + b

//  addTwoBoxesWithFilter(Box(1), Box(2))     // should return Box(1)
//  addTwoBoxesWithFilter(Box(1), Box(5))     // should return Box(6)
//  addTwoBoxesWithFilter(Box(5), Box(10))    // should return Box(15)

}
