package m3.forComprehension

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class Ex1_OptionalWithForComprehensionTest extends AnyFunSuite with Matchers {

  val ex1 = new Ex1_OptionalWithForComprehension

  test("addOptsWithFlatMap function should return sum of Options") {
    val addOptsWithFlatMap = ex1.addOptsWithFlatMap(Some(3), Some(5))

    addOptsWithFlatMap should be(Some(8))
  }

  test("addTwoOpts function should return sum of Options") {
    val addTwoOpts = ex1.addTwoOpts(Some(3), Some(5))

    addTwoOpts should be(Some(8))
  }

  test("addThreeOptsWithFlatMap function should return sum of Options") {
    val addThreeOptsWithFlatMap = ex1.addThreeOptsWithFlatMap(Some(3), Some(5), Some(2))

    addThreeOptsWithFlatMap should be(Some(10))
  }

  test("addThreeOpts function should return sum of Options") {
    val addThreeOpts = ex1.addThreeOpts(Some(3), Some(5), Some(2))

    addThreeOpts should be(Some(10))
  }

  test("addTwoOptsWithFlatMapAndFilter function should return sum of Options") {
    val addTwoOptsWithFlatMapAndFilter = ex1.addTwoOptsWithFlatMapAndFilter(Some(7), Some(6))

    addTwoOptsWithFlatMapAndFilter should be(Some(13))
  }

  test("addTwoOptsWithFlatMapAndFilter function should return None of Options if one below 5") {
    val addTwoOptsWithFlatMapAndFilter = ex1.addTwoOptsWithFlatMapAndFilter(Some(7), Some(3))

    addTwoOptsWithFlatMapAndFilter should be(None)
  }

  test("addTwoOptsWithFilter function should return sum of Options") {
    val addTwoOptsWithFilter = ex1.addTwoOptsWithFilter(Some(7), Some(6))

    addTwoOptsWithFilter should be(Some(13))
  }

  test("addTwoOptsWithFilter function should return None of Options if one below 5") {
    val addTwoOptsWithFilter = ex1.addTwoOptsWithFilter(Some(7), Some(3))

    addTwoOptsWithFilter should be(None)
  }

}
