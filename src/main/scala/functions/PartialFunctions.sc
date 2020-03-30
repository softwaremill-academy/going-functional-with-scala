List(1, 2, 3, 4).collect {
  case x if x == 3 || x == 4 => Some(x)
  case x if x == 1 => None
}.flatten

val pf = new PartialFunction[Int, Int] {
  def isDefinedAt(x: Int) = x != 0

  def apply(v1: Int) = v1 + 1
}

List(0, 1, 2, 3).collect(pf)

List(1, 2).map(x => x + 1)
List(1, 2).map(_ + 1)


List(1, 2, 3).flatMap {
  case x if x == 3 => List(1)
  case _ => List()
}