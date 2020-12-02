case class Person(firstName: String, lastName: String)

// must import this to enable implicit conversions

//import scala.language.implicitConversions

// define the implicit conversion. String to Person in this case
implicit def stringToPerson(name: String): Person = {
  val fields = name.split(" ")
  Person(fields(0), fields(1))
}

// method using the implicit conversion  
def getPerson(fullName: String): Person = fullName

val fooBar = getPerson("Jan Kowalski")

println(fooBar.getClass)
println(fooBar.firstName)
println(fooBar.lastName)