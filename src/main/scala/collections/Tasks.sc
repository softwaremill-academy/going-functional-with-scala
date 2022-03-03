import cats.{Eval, Foldable}

/**
  * Use foldLeft to write a function called ‘contains’ that takes a List[A] and an item of type A,
  * and returns true if the item is one of the members of the list, and false if it isn’t.
*/

def contains[A](list: List[A], item: A): Boolean = ???

/**
Use foldLeft to write a function called ‘reverseL’ that takes a List and returns the same list in reverse order.
  */

def reverseL[A](list: List[A]): List[A] = ???

/**
Use foldRight to write a function called ‘reverseR’ that takes a List and returns the same list in reverse order.
  */

def reverseR[A](list: List[A]): List[A] = ???

List(1, 2, 3).foldLeft("")((acc, n) => acc + n.toString)

Foldable[List].foldRight(List(1, 2, 3), Eval.now(""))((n, acc) => acc.map(_.prepended(n.toString).mkString)).value