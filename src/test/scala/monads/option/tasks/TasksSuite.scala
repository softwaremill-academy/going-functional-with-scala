package monads.option.tasks

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import monads.option.tasks.Task._


class TasksSuite extends AnyFlatSpec with Matchers {

  "addOptsWithFlatMap" should "return Option of its ingredients" in {

    val result = addOptsWithFlatMap(Option(2), Option(3))

    result should equal(Some(5))

  }

  "addTwoOpts" should "return Option of its ingredients using for comprehension" in {

    val result = addTwoOpts(Option(3), Option(4))

    result should equal(Some(7))

  }

  "addTwoOpts" should "return None from None and Some" in {

    val result = addTwoOpts(None, Option(4))

    result should equal(None)

  }

  "addTwoOpts" should "return None from Some and None" in {

    val result = addTwoOpts(Option(4), None)

    result should equal(None)

  }

  "addThreeOptsWithFlatMap" should "return sum of three Options" in {

    val result = addThreeOptsWithFlatMap(Option(1), Option(2), Option(3))

    result should equal(Some(6))

  }

  "addThreeOpts" should "return sum of three Options" in {

    val result = addThreeOpts(Option(1), Option(2), Option(3))

    result should equal(Some(6))

  }

  "addTwoOptsWithFlatMapAndFilter" should "return None while argument <= 5" in {

    val result = addTwoOptsWithFlatMapAndFilter(Option(6), Option(5))

    result should equal(None)

  }

  "addTwoOptsWithFlatMapAndFilter" should "return Some while argument > 5" in {

    val result = addTwoOptsWithFlatMapAndFilter(Option(6), Option(6))

    result should equal(Some(12))

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
