Seq(1,2,3).map(_ * 3)

for {
  x <- Seq(1,2,3)
} yield x * 3

val seq = Seq(Seq(1,2), Seq(3,4))

seq.map(_.map(_ * 3))

seq.flatMap(s => s.map(u => u * 3))

seq.flatMap(_.map(_ * 3))

seq.flatMap { s =>
  s.map { u =>
    u * 3
  }
}


for {
  x <- seq
  y <- x
} yield y * 3