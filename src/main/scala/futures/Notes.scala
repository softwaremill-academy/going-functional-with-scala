package futures

import scala.concurrent.Future

object Notes extends App {

  // use Future.apply to create a Future that takes 1s and fails randomly
  // discuss execution contexts, pass an EC explicitly

  // handle the resulting Try with onComplete
  // note that the callbacks are actually not executed

  // demonstrate Await

  // transform, andThen, recover[With]

  // show successful/failed for already computed results

  // demonstrate eager behavior
  // create two Future[Int] (as val's), bo th log start and end, one takes 3s, the other - 1 s
  // chain them in a for-comprehension to obtain a sum
  // are the futures actually chained, i.e. run sequentially?

  // demonstrate sequence and firstCompletedOf
}
