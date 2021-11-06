package futures

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration
import scala.util.{Failure, Random, Success}

object Futures extends App {

  val result = Future {
    println(Thread.currentThread().getName)
    if (Random.nextBoolean()) 42
    else throw new RuntimeException("boom!")
  }

  result.onComplete {
    case Success(n) => println(s"Success: $n")
    case Failure(e) => println(s"Failure: ${e.getMessage}")
  }

  Await.result(result, Duration.Inf)

  Future.successful(1)
  Future.failed(new RuntimeException)
}
