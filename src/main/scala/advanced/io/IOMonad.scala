package advanced.io

class IOMonad[A] private(blockOfCode: => A) {
  def flatMapOrig[B](f: A => IOMonad[B]): IOMonad[B] = IOMonad(f(run).run)

  def run = blockOfCode

  def flatMap[B](customAlgorithm: A => IOMonad[B]): IOMonad[B] = {
    val result1 = customAlgorithm(run)
    val result2 = result1.run
    IOMonad(result2)
  }

  def map[B](f: A => B): IOMonad[B] = {
    flatMap(a => IOMonad(f(a)))
  }
}

object IOMonad {
  def apply[A](blockOfCode: => A): IOMonad[A] = new IOMonad(blockOfCode)
}