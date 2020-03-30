def combine(x: Int)(y: Int): Int = x + y

val add10 = combine(10)(_)

//Curried functions - quirks

def add(x: Int, y: Int) = x + y

def subtract(x: Int, y: Int) = x - y

val calculations = Map(
  "add" -> add,
  "subtract" -> subtract
)

val subFun = calculations("subtract")

subFun(2, 1)