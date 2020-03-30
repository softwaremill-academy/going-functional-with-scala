package functions

class CurryingJVM {

  def add(x: Int, y: Int) = x + y
  def addCurried(a: Int)(b: Int) = a + b
}

