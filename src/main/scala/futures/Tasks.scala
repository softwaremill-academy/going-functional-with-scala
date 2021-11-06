package futures

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration

object Tasks extends App {

  val f1 = Future {
    println("f1 start")
    Thread.sleep(3000)
    println("f1 end")
    1
  }

  val f2 = Future {
    println("f2 start")
    Thread.sleep(1000)
    println("f2 end")
    2
  }

  // run f1 and f2 in a for-comprehension and Await.result
  // is the flow of execution as expected?

  // now change val to def (or lazy val) and run again
}
