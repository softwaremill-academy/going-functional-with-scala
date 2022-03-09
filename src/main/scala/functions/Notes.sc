// basic definition

// named parameters

// default parameter values

// by-name parameters

// varargs + sequences as vararg

// function composition

// eta-expansion

// currying
// Int => Int => Int

// multiple parameter lists -> type inference
def f[A](a: A, f: A => Int)
// vs
def g[A](a: A)(f: A => Int)

// partially applied functions

// partial functions (collect, error handling)

// exercise - partiallly applied and partial functions