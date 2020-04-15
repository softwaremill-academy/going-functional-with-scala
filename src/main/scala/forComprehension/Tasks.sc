// Let's define a case class Box[Int]
case class Box(value: Int)

/*
* Task 1: Using for comprehension take the value out of the Box[Int] type,
* add 5 to it and return as Box(5).
*/

def addFive(v1: Box) = ???

addFive(Box(2)) // should receive Box(7)
addFive(Box(0)) // should receive Box(5)

/*
* Task 2: Using for comprehension take the values out of the two Box[Int] types,
* add them together and return in Box.
*/

def addTwoBoxes(v1: Box, v2: Box) = ???

addTwoBoxes(Box(1), Box(9))   // should receive Box(10)
addTwoBoxes(Box(0), Box(5))   // should receive Box(5)

/*
* Task 3: Using for comprehension take the values out of the two Box[Int] types,
* and add them together if v2 >= 5
*/

def addTwoBoxesWithFilter(v1: Box, v2: Box) = ???

addTwoBoxesWithFilter(Box(1), Box(2))     // should return Box(1)
addTwoBoxesWithFilter(Box(1), Box(5))     // should return Box(6)
addTwoBoxesWithFilter(Box(5), Box(10))    // should return Box(15)