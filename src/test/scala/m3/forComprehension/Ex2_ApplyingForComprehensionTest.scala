package m3.forComprehension

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers


class Ex2_ApplyingForComprehensionTest extends AnyFunSuite with Matchers {

  val ex2 = new Ex2_ApplyingForComprehension

  test("addFive function should add 5 to box value") {
    val box = ex2.Box(10)
    val addFive = ex2.addFive(box)

    addFive should be(ex2.Box(15))
  }

  test("addTwoBoxes function should sum boxes values") {
    val box1 = ex2.Box(10)
    val box2 = ex2.Box(20)
    val addTwoBoxes = ex2.addTwoBoxes(box1, box2)

    addTwoBoxes should be(ex2.Box(30))
  }

  test("addTwoBoxesWithFilter function should sum boxes values if second value >= 5") {
    val box1 = ex2.Box(1)
    val box2 = ex2.Box(5)
    val addTwoBoxesWithFilter = ex2.addTwoBoxesWithFilter(box1, box2)

    addTwoBoxesWithFilter should be(ex2.Box(6))
  }

  test("addTwoBoxesWithFilter function should return first box value if second's box value < 5") {
    val box1 = ex2.Box(1)
    val box2 = ex2.Box(2)
    val addTwoBoxesWithFilter = ex2.addTwoBoxesWithFilter(box1, box2)

    addTwoBoxesWithFilter should be(ex2.Box(1))
  }

}
