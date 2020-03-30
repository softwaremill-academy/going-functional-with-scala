//Underscore idioms

List(1, 2, 3).map((x: Int) => println(x))
List(1, 2, 3).map(x => println(x))
List(1, 2, 3).map(println _)
List(1, 2, 3).map(println)        //Java: System.out::println

List(1, 2, 3).foreach(println)
Option(1).map(_ + 1)

def inc(x: Int) = x + 1
Option(1).map(inc)
Option(1)