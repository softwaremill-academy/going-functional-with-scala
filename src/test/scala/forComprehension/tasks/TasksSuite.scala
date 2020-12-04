package forComprehension.tasks

import forComprehension.tasks.OptionFCTask._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class TasksSuite extends AnyFlatSpec with Matchers {


  "addTwoOpts" should "return None from Some and None" in {

    val result = addTwoOpts(Option(4), None)

    result should equal(None)

  }

  "addTwoOpts" should "return None from None and Some" in {

    val result = addTwoOpts(None, Option(4))

    result should equal(None)

  }

  "addTwoOpts" should "return Option of its ingredients using for comprehension" in {

    val result = addTwoOpts(Option(3), Option(4))

    result should equal(Some(7))

  }

  "addThreeOpts" should "return sum of three Options" in {

    val result = addThreeOpts(Option(1), Option(2), Option(3))

    result should equal(Some(6))

  }

  "addTwoOptsWithFilter" should "return None while single argument <= 5" in {

    val result = addTwoOptsWithFilter(Option(5), Option(6))

    result should equal(None)

  }

  "addTwoOptsWithFilter" should "return Some while argument > 5" in {

    val result = addTwoOptsWithFilter(Option(6), Option(6))

    result should equal(Some(12))

  }
}
