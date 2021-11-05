package m3.forComprehension

class Ex1_OptionalWithForComprehension {

  /*
  * Task 1: Using flatMap and map,
  * write a method addOpts that accepts two Option parameters of type Option[Int] and adds them together.
  */

  def addOptsWithFlatMap(optValue1: Option[Int], optValue2: Option[Int]): Option[Int] = optValue1.flatMap { a =>
    optValue2.map(b => a + b)
  }
  /*
  * Task 2: Using for comprehension,
  * write a method addOpts that accepts two Option parameters of type Option[Int] and adds them together.
  */

  def addTwoOpts(optValue1: Option[Int], optValue2: Option[Int]): Option[Int] = for {
    a <- optValue1
    b <- optValue2
  } yield a + b

  /*
  * Task 3: Using flatMap and map
  * extend the previous method to accept three Option parameters of type Option[Int].
  */

  def addThreeOptsWithFlatMap(optValue1: Option[Int], optValue2: Option[Int], optValue3: Option[Int]): Option[Int] = {
//    addOptsWithFlatMap(optValue1, optValue2.flatMap{ a =>
//      optValue3.map(b => a + b)
//    })
    optValue1.flatMap { a =>
      optValue2.flatMap { b =>
        optValue3.map(c => a + b + c)
      }
    }
  }

  /*
  * Task 4: Using for comprehension
  * extend the previous method to accept three Option parameters of type Option[Int].
  */

  def addThreeOpts(optValue1: Option[Int], optValue2: Option[Int], optValue3: Option[Int]): Option[Int] = {
//    addTwoOpts(optValue1, for {
//      b <- optValue2
//      c <- optValue3
//    } yield b + c)

//    addTwoOpts(optValue1, addTwoOpts(optValue2, optValue3))
    for {
      a <- optValue1
      b <- optValue2
      c <- optValue3
    } yield a + b + c
  }

  /*
  * Task 5: Using flatMap and map,
  * add to Option values together only if both are bigger than 5 otherwise return None
  */

  def addTwoOptsWithFlatMapAndFilter(optValue1: Option[Int], optValue2: Option[Int]): Option[Int] = {
    optValue1
      .filter(n => n > 5)
      .flatMap { a =>
        optValue2
          .filter(n => n > 5)
          .map(b => a + b)
      }
  }

  /*
  * Task 6: Using for comprehension
  * add to Option values together only if both are bigger than 5 otherwise return None
  */

  def addTwoOptsWithFilter(optValue1: Option[Int], optValue2: Option[Int]): Option[Int] = for {
      a <- optValue1
      if a > 5
      b <- optValue2
      if b > 5
    } yield a + b

//  addTwoOptsWithFilter(Option(1), Option(2)) // should return None
//  addTwoOptsWithFilter(Option(6), Option(6)) // should return Some(12)

}
