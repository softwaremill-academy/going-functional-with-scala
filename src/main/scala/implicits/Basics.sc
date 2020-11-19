implicit val minOrdering = Ordering.fromLessThan[Int](_ < _)

implicit val maxOrdering = Ordering.fromLessThan[Int](_ > _)

List(4,1,2,3).sorted
