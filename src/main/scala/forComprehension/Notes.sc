// demonstrate how various for-comprehensions are de-sugared
// no yield = foreach
// single generator + yield = map
// multiple generators + yield = flatMap
// filter expressions = withFilter
// definitions = additional map to tuple

// given a list like this
val list = List(Option(1), None, Option(2), Option(3))

// multiply all defined values by 3  - i.e. obtain a List(3, 6, 9)

// why does a combination of List and Option work in a for-comprehension

// exercise - adding Maybes
