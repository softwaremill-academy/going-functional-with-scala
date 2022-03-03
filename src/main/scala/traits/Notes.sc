trait JsonWriter[-A] {
  def toJson(v: A): String
}

object JsonWriter {
  def toJson[A](v: A)(implicit writer: JsonWriter[A]): String = writer.toJson(v)

  implicit class JsonWriterSyntax[A](v: A) {
    def toJson(implicit writer: JsonWriter[A]): String = writer.toJson(v)
  }

  implicit def listWriter[A](implicit writer: JsonWriter[A]) = new JsonWriter[List[A]] {
    def toJson(vs: List[A]): String = s"""[${vs.map(_.toJson).mkString(",")}]"""
  }
}

class Person(val name: String)

object Person {
  implicit val personWriter = new JsonWriter[Person] {
    override def toJson(v: Person): String = s"""{"name":"${v.name}"}"""
  }
}

class Employee(override val name: String, val department: String) extends Person(name)

object Employee {
  implicit val employeeWriter = new JsonWriter[Employee] {
    override def toJson(v: Employee): String = s"""{"name":"${v.name}","department":"${v.department}"}"""
  }
}

//object TypeClassTest extends App {
  import JsonWriter.JsonWriterSyntax

  val p = new Person("Joe Smith")
  val e = new Employee("Bob Builder", "Development")

  println("Person:")
  println(p.toJson)
  println(List(p).toJson)
  println("Employee:")
//  println(e.toJson)
//  println(List(e).toJson)
  println("Mixed:")
  println(List(p, e).toJson)
//}