package advanced.io

import cats.effect.IO

object IOMonadExample extends App {
  def getLine: IOMonad[String] = IOMonad(scala.io.StdIn.readLine)
  def putLine(s: String): IOMonad[Unit] = IOMonad(println(s))

  val res = for {
    _ <- putLine("First name")
    firstName <- getLine
    _ <- putLine("Last name")
    lastName <- getLine
    _ <- putLine(s"First name: $firstName, last name: $lastName")
  } yield()

  res.run
}

object IOExample extends App {
  val helloEffect = IO { println("Hello, World")}

  // discuss the need of choosing the right thread pool or using IOApp instead
  helloEffect.unsafeRunSync()(cats.effect.unsafe.implicits.global)
}