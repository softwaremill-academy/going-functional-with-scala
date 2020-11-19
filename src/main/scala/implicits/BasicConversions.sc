import scala.language.implicitConversions

def double2Int = (x: Double) => x.toInt

val x: Int = 2


//implicit def intToBool(int: Int) = int == 0

//if(intToBool(1)) true else false