
import scala.language.implicitConversions
implicit def double2Int = (x: Double) => x.toInt

val x: Int = double2Int(2.3)

implicit def intToBool(int: Int) = int == 0

if(intToBool(1)) true else false