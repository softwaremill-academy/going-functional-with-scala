package functions

class CurryingJVM {

  def add(x: Int, y: Int) = x + y
  def addCurried(a: Int)(b: Int) = a + b // you can change the name to add to see what happens during compilation
}

