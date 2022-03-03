val max = 10
val Min = 0

object Test {
  val x: Int = 10
}

def process(input: Int) {
  input match {
    case Test.x => println("Don't try this at home")
    case Min => println("You matched min")
    case _ => println("Unreachable!!")
  }
}



process(10)

