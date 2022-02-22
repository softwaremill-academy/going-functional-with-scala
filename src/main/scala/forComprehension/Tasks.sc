// Let's define a case class Maybe[Int]
case class Maybe(value: Int)

/*
* Task 1: Using for comprehension take the value out of the Maybe[Int] type,
* add 5 to it and return as Maybe(5).
*/

def addFive(v1: Maybe) = ???

addFive(Maybe(2)) // should receive Maybe(7)
addFive(Maybe(0)) // should receive Maybe(5)

/*
* Task 2: Using for comprehension take the values out of the two Maybe[Int] types,
* add them together and return in Maybe.
*/

def addTwoMaybes(v1: Maybe, v2: Maybe) = ???

addTwoMaybes(Maybe(1), Maybe(9))   // should receive Maybe(10)
addTwoMaybes(Maybe(0), Maybe(5))   // should receive Maybe(5)

/*
* Task 3: Using for comprehension take the values out of the two Maybe[Int] types,
* and add them together if v2 >= 5
*/

def addTwoMaybesWithFilter(v1: Maybe, v2: Maybe) = ???

addTwoMaybesWithFilter(Maybe(1), Maybe(2))     // should return Maybe(1)
addTwoMaybesWithFilter(Maybe(1), Maybe(5))     // should return Maybe(6)
addTwoMaybesWithFilter(Maybe(5), Maybe(10))    // should return Maybe(15)