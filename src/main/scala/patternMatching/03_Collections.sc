def matchList(xs: List[Int]): Unit = xs match {
  case List(1, 2, _) => println("three elements starting with 1, 2")
  case List(1, _*) => println("starts with 1") // or case head :: _ if head == 1
  case 2 :: tail => println(s"2 and $tail") // or case List(1, tail @ _*)
  case head :: _ => println(s"starts with $head")
  case Nil => println("empty list")
}

matchList(List(1, 2, 3))
matchList(List(1, 2, 4))
matchList(List(1, 2, 3, 4))
matchList(List(2, 3, 4))
matchList(List(5, 3, 4))
