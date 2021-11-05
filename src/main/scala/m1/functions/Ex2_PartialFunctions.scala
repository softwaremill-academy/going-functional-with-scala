package m1.functions

class Ex2_PartialFunctions {

  /**
    * Implement a partial function by implementing PartialFunction trait,
    * that is defined only for strings longer than five characters and returns a tuple of the string itself and its length
    * E.g.
    * ("softwaremill", 12)
    */
  val partialFunction = new PartialFunction[String, (String, Int)] {
    override def isDefinedAt(x: String) = x.length > 5

    override def apply(v1: String) = (v1, v1.length)
  }

  /**
    * Reimplement the function above using case blocks
    */
  val zipWithSize: PartialFunction[String, (String, Int)] = {
    case str if str.length > 5 => (str, str.length)
  }

}
