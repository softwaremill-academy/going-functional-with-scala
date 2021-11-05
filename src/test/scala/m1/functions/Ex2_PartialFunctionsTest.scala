package m1.functions

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class Ex2_PartialFunctionsTest extends AnyFunSuite with Matchers {

  val ex2 = new Ex2_PartialFunctions

  test("partialFunction function should return proper value") {
    val partialFunction = ex2.partialFunction("softwaremill")

    partialFunction should be("softwaremill", 12)
  }

  test("zipWithSize function should return proper value") {
    val zipWithSize = ex2.zipWithSize("softwaremill")

    zipWithSize should be("softwaremill", 12)
  }

  test("zipWithSize function should throw MatchError when string.length is equal to or lower than 5") {
    val ex = the[MatchError] thrownBy ex2.zipWithSize("start")
    ex.getMessage should include("start")
  }

}
