package m5.typeclasses

object Ex1_TypeClasses extends App {

  case class User(name: String, age: Int)

  // type class Equal[T]
  trait Equal[T] {
    def apply(a: T, b: T): Boolean
  }

  /*
   * Basing on type class Equal, create type class instances for comparing User data:
   * - by name
   * - by name and age
   */

  implicit object NameEquality extends Equal[User] {
    override def apply(a: User, b: User): Boolean = a.name == b.name
  }

  object FullEquality extends Equal[User] {
    override def apply(a: User, b: User): Boolean = a.name == b.name && a.age == b.age
  }

  /*
   * Implement the companion object for the Equal type class with apply method so that below comparing should works
   */
  object Equal {
    def apply[T](a: T, b: T)(implicit equalizer: Equal[T]): Boolean = equalizer.apply(a, b)
  }

  val john = User("John", 25)
  val olderJohn = User("John", 42)

  println(Equal(john, olderJohn)) // should returns true for comparing by name and should returns false comparing by name and age

  /*
   * Improve the Equal TC with an implicit conversion class
   * ===(anotherValue: T)
   * !==(anotherValue: T)
   */
  implicit class TypeSafeEqual[T](value: T) {
    def ===(anotherValue: T)(implicit equalizer: Equal[T]): Boolean = equalizer.apply(value, anotherValue)
    def !==(anotherValue: T)(implicit equalizer: Equal[T]): Boolean = ! equalizer.apply(value, anotherValue)
  }
  println(john === olderJohn) // should returns true for comparing by name and should returns false comparing by name and age

}
