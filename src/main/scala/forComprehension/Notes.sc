val list = List(Option(1), Option(2), Option(3))

for {
  opt <- list
  x <- opt
} yield x * 3

list.flatMap { opt =>
  opt.map { x =>
    x * 3
  }
}
list.flatMap(opt => opt.map(x => x * 3))

case class Box[A](value: A) {
  def map[B](f: A => B): Box[B] = Box(f(value))
  def flatMap[B](f: A => Box[B]): Box[B] = f(value)
//  def flatMap[B](f: A => Box[B]): Box[B] = f(value)
}

val boxList: List[Box[Int]] = List(Box(1), Box(2), Box(3))

for {
  b <- boxList
  x <- b
} yield x * 3
