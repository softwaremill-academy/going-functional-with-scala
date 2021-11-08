//define two functions Int => Int
val f: Int => Int = _ + 2
val g: Int => Int = _ * 3

val composed = f andThen g // g(f(x))
composed(4)