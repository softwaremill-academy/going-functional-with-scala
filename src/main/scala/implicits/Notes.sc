// conversions (primitives, case classes)

// parameters

// context bounds, implicitly

// implicit classes - extension methods

// implicit scopes (local, companion object) and conflicts

// given
def reverseSort[A: Ordering](xs: Seq[A]) = xs.sorted.reverse

// implement Ordering for some custom case class A(value: Int)
