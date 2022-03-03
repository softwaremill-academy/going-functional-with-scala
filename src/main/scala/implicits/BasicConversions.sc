import scala.language.implicitConversions

implicit def double2Int = (x: Double) => x.toInt

val x: Int = 2.4 // Double => Int

val x: Int = double2Int(2.3)


implicit def intToBool(int: Int) = int == 0

if(0) true else false