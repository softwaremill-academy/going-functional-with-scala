// everything is a method call, but you can omit . and ()
2.+(2).==(4)

// types - ???, Nothing, Predef
def foo = throw new RuntimeException()

// val/lazy val/def - eager/lazy + memoization
val x: Int = {
  println("x")
  2
}

def y: Int = {
  println("y")
  2
}
y
y

lazy val z: Int = {
  println("z")
  2
}
z
z

// string interpolators - s, f, how they actually work (StringContext)
s"x = ${x + 2}"

// tuples
val t1 = Tuple2(1, 2)
val t2 = (1, "Jacek", true)

val (a, b, c) = t2
a
b
c
