def add(x: Int, y: Int) = x + y

def plus(x: Int)(y: Int) = x + y


val addFunction = add _

addFunction.isInstanceOf[Function2[_, _, _]]

/**
  * The technique of converting a def method into a function
  * uses Eta-Expansion
  * Ok, so now we have a true function (Int, Int) => Int
  * but we'd like to have (Int) => (Int) => Int
  */

val addCurried = addFunction.curried

addCurried(1)(2)

//Pass a block of code