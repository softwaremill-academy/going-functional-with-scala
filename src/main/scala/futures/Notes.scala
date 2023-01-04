package futures

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Random, Success}

object Notes extends App {

  // use Future.apply to create a Future that takes 1s and fails randomly
  // discuss execution contexts, pass an EC explicitly
  val f = Future {
    Thread.sleep(1000)
    if (Random.nextBoolean() || true) println("test") else throw new RuntimeException("error")
  }(scala.concurrent.ExecutionContext.global)

  // handle the resulting Try with onComplete
  // note that the callbacks are actually not executed
  f.onComplete {
    case Failure(exception) => println(exception.getMessage)
    case Success(value) => println(value)
  }(scala.concurrent.ExecutionContext.global)

  // demonstrate Await
  Await.ready(f, Duration.Inf)

  // transform, andThen, recover[With]


  // show successful/failed for already computed results
  def foo: Future[Int] = Future.failed(new RuntimeException())

  // demonstrate eager behavior
  // create two Future[Int] (as val's), both log start and end, one takes 3s, the other - 1 s
  // chain them in a for-comprehension to obtain a sum
  // are the futures actually chained, i.e. run sequentially?

  // demonstrate sequence and firstCompletedOf
  private val fs: List[Future[Int]] = List(Future.successful(1), Future.successful(2))
  // Future[List[Int]]

  import scala.concurrent.ExecutionContext.Implicits.global

  private val future: Future[List[Int]] = Future.sequence(fs)
  Future.traverse(fs)(_.map(_ + 1))
  private val eventualInt: Future[Int] = Future.firstCompletedOf(fs)

}
