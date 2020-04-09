sealed trait Shape {
  def sides: Int

  def perimeter: Double

  def area: Double
}

/**
  * Define a trait called Shape with three abstract methods:
  * sides, perimeter, area
  * Implement Shape with three classes Circle, Rectangle and Square
  */

/**
  * Hint:
  * perimeter for a circle: 2 * math.Pi * radius
  * area for circle: math.Pi * radius * radius
  */


final case class Circle(radius: Double) extends Shape {
  val sides = 1
  val perimeter = 2 * math.Pi * radius
  val area = math.Pi * radius * radius
}

case class Rectangle(width: Double, height: Double) extends Shape {
  val sides = 4
  val perimeter = 2 * width + 2 * height
  val area = width * height
}

case class Square(size: Double) extends Shape {
  val sides = 4
  val perimeter = 4 * size
  val area = size * size
}

/**
  * Square and Rectangle are not just shapes. Refactor it.
  * Create their common trait and connect it to Shape trait
  */

trait Rectangular extends Shape {
  def width: Double

  def height: Double

  val sides = 4
  override val perimeter = 2 * width + 2 * height
  override val area = width * height
}

case class Square(size: Double) extends Rectangular {
  val width = size
  val height = size
}

case class Rectangle(width: Double, height: Double) extends Rectangular