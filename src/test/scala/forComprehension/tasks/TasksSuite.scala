package forComprehension.tasks

import forComprehension.tasks.BoxTasks._
import forComprehension.tasks.OptionTasks._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class TasksSuite extends AnyFlatSpec with Matchers {


  "addTwoOpts" should "return None from Some and None" in {

    addTwoOpts(Option(4), None) should equal(None)
    addTwoOpts(None, Option(4)) should equal(None)

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

  "addFive invoked on Box" should "return Boxed internally increased by 5" in {

    addFive(Box(2)) should equal(Box(7))
    addFive(Box(0)) should equal(Box(5))
  }


  "addTwoBoxes" should "return Boxed result with summed the internal values" in {

    val result = addTwoBoxes(Box(1), Box(9))

    result should equal(Box(10))

  }

  "addTwoBoxesWithFilter" should "sum both Boxed values if the internal value >= 5" in {

    addTwoBoxesWithFilter(Box(1), Box(2)) should equal(Box(1))
    addTwoBoxesWithFilter(Box(1), Box(5)) should equal(Box(6))
    addTwoBoxesWithFilter(Box(5), Box(10)) should equal(Box(15))

  }
}
