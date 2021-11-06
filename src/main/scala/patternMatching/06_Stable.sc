val max = 10
val Min = 0

def process(input: Int) {
  input match {
    case max => println("Don't try this at home")
    case Min => println("You matched min")
    case _ => println("Unreachable!!")
  }
}

process(1)

