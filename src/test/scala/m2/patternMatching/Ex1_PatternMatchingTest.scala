package m2.patternMatching

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import java.time.LocalDateTime

class Ex1_PatternMatchingTest extends AnyFunSuite with Matchers {

  val ex1 = new Ex1_PatternMatching

  test("isEven function should return true for even number") {
    val isEven = ex1.isEven(4)

    isEven should be(true)
  }

  test("isEven function should return false for odd number") {
    val isEven = ex1.isEven(3)

    isEven should be(false)
  }

  test("isEmailCorrect function should return true for valid email") {
    val registeredUser = ex1.RegisteredUser("1", "joe", "joe@gmail.com", 17, LocalDateTime.now())

    val isEmailCorrect = ex1.isEmailCorrect(registeredUser)

    isEmailCorrect should be(true)
  }

  test("isEmailCorrect function should return false for invalid email") {
    val registeredUser = ex1.RegisteredUser("1", "joe", "", 17, LocalDateTime.now())

    val isEmailCorrect = ex1.isEmailCorrect(registeredUser)

    isEmailCorrect should be(false)
  }

  test("addTwoElements function should return sum of two first elements in the list") {
    val addTwoElements = ex1.addTwoElements(List(1,2,3))

    addTwoElements should be(3)
  }

  test("addTwoElements function should return sum of two first elements in the list of one element") {
    val addTwoElements = ex1.addTwoElements(List(1))

    addTwoElements should be(1)
  }

  test("addTwoElements function should return sum of two first elements in the empty list") {
    val addTwoElements = ex1.addTwoElements(List())

    addTwoElements should be(0)
  }

  test("addTwoIntOptions function should return sum of two int options") {
    val addTwoIntOptions = ex1.addTwoIntOptions(Some(1), Some(2))

    addTwoIntOptions should be(Some(3))
  }

  test("addTwoIntOptions function should return first option when other is None") {
    val addTwoIntOptions = ex1.addTwoIntOptions(Some(1), None)

    addTwoIntOptions should be(Some(1))
  }

  test("addTwoIntOptions function should return None when both are None") {
    val addTwoIntOptions = ex1.addTwoIntOptions(None, None)

    addTwoIntOptions should be(None)
  }

}
