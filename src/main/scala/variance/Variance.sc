import cats.syntax.MonadIdOps

/* How do two types with a subtype relationship
   relate in type parametrization with each other?
*/

trait Animal
class Cat extends Animal

trait SmallAnimal extends Animal

class Mouse extends SmallAnimal

// Function1[-T, +R]
def doStuff(f: Cat => SmallAnimal) = ???
def doOtherStuff(f: Animal => Mouse) = ???
//
val f: Cat => SmallAnimal = ???
val g: Animal => Mouse = ???
//
doStuff(f)
doOtherStuff(f)
doStuff(g)
doOtherStuff(g)