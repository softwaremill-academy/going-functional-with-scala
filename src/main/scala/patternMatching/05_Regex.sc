val facts = List(
  "I ate 2 apples",
  "I ate 3 bananas",
  "I ate 14 apples"
)

val regex = """I ate (\d+) (\w+)""".r

facts.foreach {
  case regex(count, fruit) => println(s"$fruit: $count")
}

facts
  .map { case regex(count, fruit) => (fruit, count.toInt) }
  .groupBy(_._1)
  .mapValues(_.map(_._2).sum)

