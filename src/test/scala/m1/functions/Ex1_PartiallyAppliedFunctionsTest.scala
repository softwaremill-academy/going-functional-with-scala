package m1.functions

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class Ex1_PartiallyAppliedFunctionsTest extends AnyFunSuite with Matchers {

  val ex1 = new Ex1_PartiallyAppliedFunctions

  test("tag function should prepare HTML code") {
    val tag = ex1.tag("<div>", "<p>Hello world</p>", "</div>")

    tag should be("<div><p>Hello world</p></div>")
  }

  test("tagWithDiv function should prepare HTML code") {
    val tagWithDiv = ex1.tagWithDiv("<p>Hello world</p>")

    tagWithDiv should be("<div><p>Hello world</p></div>")
  }

  test("tagWithSpan function should prepare HTML code") {
    val tagWithSpan = ex1.tagWithSpan("<p>Hello world</p>")

    tagWithSpan should be("<span><p>Hello world</p></span>")
  }

}
