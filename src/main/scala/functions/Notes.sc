// function composition

// eta-expansion

// multiple parameter lists -> type inference
def f[A](a: A, f: A => Int)
// vs
def g[A](a: A)(f: A => Int)

f(1, _ + 1)
g(1)(_ + 1)

// currying

// Int => Int => Int

// partially applied functions

// partial functions