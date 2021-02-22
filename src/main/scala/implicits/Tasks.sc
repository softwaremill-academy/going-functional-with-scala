/**
  * Implement an implicit class that takes an int value `i` and has `fuckYeah` method that prints "fuckYeah" i times.
  */

implicit class FuckYeah(s: String) {
  def fuckYeah(i: Int) = {
    for { _ <- 0 until i } println("Fuck Yeah")
  }
}
/**
  * Use your previous implicit class and change it. Your new implicit class should:
  * - have fuckYeah method
  * - times method that takes a function parameter Int => Unit
  */

implicit class FuckYeahInt(n: Int) {
  def fuckYeah() = times(_ => println("Fuck Yeah"))

  def times(func: Int => Unit) =
    for(i <- 0 until n) func(i)
}

3.times(i => println("Oh yeah"))