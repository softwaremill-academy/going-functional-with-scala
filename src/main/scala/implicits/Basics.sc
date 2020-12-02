//implicit val minOrdering = Ordering.fromLessThan[Int](_ < _)

//implicit val maxOrdering = Ordering.fromLessThan[Int](_ > _)
object SortingStrategies {
  implicit val maxOrdering = Ordering.fromLessThan[Int](_ > _)
  implicit val minOrdering = Ordering.fromLessThan[Int](_ < _)

}

import SortingStrategies.minOrdering
List(4,1,2,3).sorted

//import SortingStrategies.maxOrdering

List(5,6,7,1).sorted