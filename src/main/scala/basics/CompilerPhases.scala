package basics

class CompilerPhases {

  val i = 23
  val j = "blah"
  val k = i + j

  private def wibble = {
    for (c <- k) yield c * 2
  }
}