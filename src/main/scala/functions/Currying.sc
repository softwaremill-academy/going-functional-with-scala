def plus(x: Int)(y: Int) = x + y

def plus3 = plus(3)(_)

plus3(5)

def add(x: Int, y: Int) = x + y

val addFunction = add _

(add _ ).isInstanceOf[Function2[_, _, _]]

/*
 The technique of converting a def method into a function
 uses Eta-Expansion
 Ok, so now we have a true function (Int, Int) => Int
 but we'd like to have (Int) => (Int) => Int
*/

val addCurried = addFunction.curried

addCurried(1)(2)