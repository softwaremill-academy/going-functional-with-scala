package m4.implicits

object Ex1_Implicits extends App {

  /**
    * Implement an implicit class that allows to use this methods on arbitrary x of type Int:
    * - method isEven on Int value and returns if number is Even or not
    * - method times which executes x times function f
    */
  implicit class EnrichInt(value: Int) {
    def isEven: Boolean = value % 2 == 0
    def isOdd: Boolean = !isEven
    def times(f: Int => Unit): Unit = for (i <- 0 until value) f(i)
  }

  println(3.isEven) // should prints false
  3.times(_ => println("Implicits")) // should prints Implicits 3 times

}
