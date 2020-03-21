/*
* Task 1: Using flatMap and map,
* write a method addOpts that accepts two Option parameters of type Option[Int] and adds them together.
*/

def addOptsWithFlatMap(optValue1: Option[Int], optValue2: Option[Int]) = ???

addOptsWithFlatMap(Option(1), Option(3)) // should return Some(4)
/*
* Task 2: Using for comprehension,
* write a method addOpts that accepts two Option parameters of type Option[Int] and adds them together.
*/

def addTwoOpts(optValue1: Option[Int], optValue2: Option[Int]) = ???

addTwoOpts(Option(1), Option(3))  // should return Some(4)
/*
* Task 3: Using flatMap and map
* extend the previous method to accept three Option parameters of type Option[Int].
*/

def addThreeOptsWithFlatMap(optValue1: Option[Int], optValue2: Option[Int], optValue3: Option[Int]) = ???

addThreeOptsWithFlatMap(Option(1), Option(2), Option(3)) // should return Some(6)

/*
* Task 4: Using for comprehension
* extend the previous method to accept three Option parameters of type Option[Int].
*/

def addThreeOpts(optValue1: Option[Int], optValue2: Option[Int], optValue3: Option[Int]) = ???

addThreeOpts(Option(1), Option(2), Option(3)) // should return Some(6)

/*
* Task 5: Using flatMap and map,
* add to Option values together only if both are bigger than 5 otherwise return None
*/

def addTwoOptsWithFlatMapAndFilter(optValue1: Option[Int], optValue2: Option[Int]) = ???

addTwoOptsWithFlatMapAndFilter(Option(1), Option(2)) // should return None
addTwoOptsWithFlatMapAndFilter(Option(6), Option(6)) // should return Some(12)

/*
* Task 6: Using for comprehension
* add to Option values together only if both are bigger than 5 otherwise return None
*/

def addTwoOptsWithFilter(optValue1: Option[Int], optValue2: Option[Int]) = ???

addTwoOptsWithFilter(Option(1), Option(2)) // should return None
addTwoOptsWithFilter(Option(6), Option(6)) // should return Some(12)
