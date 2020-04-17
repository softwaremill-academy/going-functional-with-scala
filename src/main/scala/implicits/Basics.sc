
object Max {
  implicit val maxOrdering = Ordering.fromLessThan[Int](_ > _)
}

object Min {
  implicit val minOrdering = Ordering.fromLessThan[Int](_ < _)
}

object Implicits {
  def sortList() = {

    import Min._
    List(1, 2, 3).sorted
  }
}

Implicits.sortList()
