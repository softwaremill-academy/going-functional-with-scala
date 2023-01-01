// None vs Option.empty, covariance
Option(1)
Option(null)
Some(1)
Some(null)
None
Option.empty[Int]

def opt: Option[Int] = Some(1)

// Option as collection
def foo(ints: IterableOnce[Int]) = ???
foo(Some(1))

// map+getOrElse
def test(opt: Option[Int]): Int = {
//  if (opt.isDefined) opt.get + 1 else 0
//  opt.map(_ + 1).getOrElse(0)
//  opt.fold(0)(_ + 1)
  opt match {
    case Some(v) => v + 1
    case None => 0
  }
}

// fold

// pattern matching