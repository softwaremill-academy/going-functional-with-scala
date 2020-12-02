package implicits.tasks

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class TasksSuite extends AnyFlatSpec with Matchers {



  "call 5.fuckYeah" should "return list of 5 strings fuckYeah while using TaskOne" in {

    import implicits.tasks.TaskOne._

    val list = 5.fuckYeah

    list should have length 5
    all (list) shouldEqual  "fuckYeah"

  }

  "call 5.fuckYeah" should "return list of 5 strings fuckYeah while using TaskTwo" in {

    import implicits.tasks.TaskTwo._

    val list = 5.fuckYeah

    list should have length 5
    all (list) shouldEqual  "fuckYeah"

  }

  "method times" should "evaluate passed function and return proper string X times" in {

    import implicits.tasks.TaskTwo._

    val list = 10.times(i => s"$i-fucked")

    list should have length 10
    all (list) should fullyMatch regex "\\d-fucked"

  }
}
