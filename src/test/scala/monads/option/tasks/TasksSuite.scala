package monads.option.tasks

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import monads.option.tasks.Task._


class TasksSuite extends AnyFlatSpec with Matchers {

  "addOptsWithFlatMap" should "return Option of its ingredients" in {

    val result = addOptsWithFlatMap(Option(2), Option(3))

    result should equal(Some(5))

  }

  "addThreeOptsWithFlatMap" should "return sum of three Options" in {

    val result = addThreeOptsWithFlatMap(Option(1), Option(2), Option(3))

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
}
