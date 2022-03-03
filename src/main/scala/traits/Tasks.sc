/**
  * Define a trait called Shape with three abstract methods:
  * sides, perimeter, area
  * Implement Shape with three case classes Circle, Rectangle and Square
  */

trait Shape {
  def sides: Int
  def perimeter: Double
  def area: Double
}

sealed trait Rectangular extends Shape {
  val width: Double
  def height: Double
  val sides = 4

  override def perimeter: Double = 2*width + 2*height

  override def area: Double = width * height
}

case class Circle(radius: Double) extends Shape {
  override def sides = ???

  override def perimeter = ???

  override def area = ???
}

case class Rectangle(width: Double, height: Double) extends Rectangular

case class Square(size: Double) extends Rectangular {
  val width = size
  val height = size
}

case class User(name: String, email: String)

val user = User("jacek", "jacek@sml.com")

val user2 = user.copy(name = "bubu")

/**
  * Hint:
  * perimeter for a circle: 2 * math.Pi * radius
  * area for circle: math.Pi * radius * radius
  */

/**
  * Square and Rectangle are not just shapes. Refactor it.
  * Create their common trait and connect it to Shape trait
  */

