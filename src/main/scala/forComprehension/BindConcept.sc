//Let's assume three functions

def f(a: Int): Int = a + 100
def g(a: Int): Int = a + 200
def h(a: Int): Int = a + 300

// f(a) -> g(a) -> h(a)

val resF = f(1)
val resG = g(resF)
val resH = h(resG)

val resCombined = h(g(f(1)))

case class Loggable[A](value: A, message: String) {
  def map[B](f: A => B): Loggable[B] = Loggable(f(value), message)

  def flatMap[B](f: A => Loggable[B]): Loggable[B] = {
    val nextValue = f(value)
    Loggable(nextValue.value, message + "\n" + nextValue.message)
  }
}

def fa(a: Int): Loggable[Int] = Loggable(a + 100, "f: a + 100")
def ga(a: Int): Loggable[Int] = Loggable(a + 200, "f: a + 200")
def ha(a: Int): Loggable[Int] = Loggable(a + 300, "f: a + 300")

val finalResult = for {
  fRes <- fa(1)
  gRes <- ga(fRes)
  hRes <- ha(gRes)
} yield hRes

