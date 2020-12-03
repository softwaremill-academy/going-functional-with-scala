/* Let's define a type Person */
case class Person(firstName: String, lastName: String)

// and a list of two people
val people = List(Person("John", "Smith"), Person("Thomas", "Jefferson"), Person("Joshua", "Smith"))

// We want to get only people with Smith last name

people.filter(p => p.lastName == "Smith")

// We need person data as upper-cased

people.map(p => p.copy(firstName = p.firstName.toUpperCase, lastName = p.lastName.toUpperCase))

// We want only people with Smith last name, upper-cased

people
  .filter(p => p.lastName == "Smith")
  .map(p => p.copy(firstName = p.firstName.toUpperCase, p.lastName.toUpperCase))

// filter(..).map(..) -> collect()

people.collect {
  case p if p.lastName == "Smith" =>
    p.copy(firstName = p.firstName.toUpperCase, lastName = p.lastName.toUpperCase)
}
for {
  p <- people
  if p.lastName == "Smith"
} yield p.copy(firstName = p.firstName.toUpperCase, lastName = p.lastName.toUpperCase)

// or

for {
  p <- people
  if p.lastName == "Smith"
  upperCasedPerson = Person(p.firstName.toUpperCase, p.lastName.toUpperCase)
} yield upperCasedPerson

