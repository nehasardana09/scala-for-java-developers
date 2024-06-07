val message = "Hello, Scala!"// Type inferred as String
assert (true, message.isInstanceOf[String])

val number = 42 // Type inferred as Int
assert(true, number.isInstanceOf[Int])

val pi = 3.14 // Type inferred as Double
assert(true, pi.isInstanceOf[Double])
//----------------------------------------------------------------------------//

//Example 2: Function Return Type Inference
def add(a: Int, b: Int) = a + b // Return type inferred as Int
assert(true, add.isInstanceOf[Int])

def greet(name: String) = s"Hello, $name!" // Return type inferred as String
assert (true, greet.isInstanceOf[String])

//----------------------------------------------------------------------------//

//Example 3: Type Inference in Collections
val numbers = List(1, 2, 3, 4, 5) // Type inferred as List[Int]
assert(true, numbers.isInstanceOf[List[Int]])

val words = Map("one" -> 1, "two" -> 2) // Type inferred as Map[String, Int]
assert(true, words.isInstanceOf[Map[String, Int]])

//----------------------------------------------------------------------------//

//Example 4: Type Inference with Higher-Order Functions
val doubled = List(1, 2, 3, 4).map(x => x * 2) // Type inferred as List[Int]
assert(true, doubled.isInstanceOf[List[Int]])

val filtered = List("apple", "banana", "cherry").filter(_.startsWith("a")) // Type inferred as List[String]
assert(true, filtered.isInstanceOf[List[String]])

//----------------------------------------------------------------------------//

//Example 5: Type Inference in Pattern Matching
def describe(x: Any) = x match {
  case i: Int => s"Int: $i" // Type inferred as String
  case s: String => s"String: $s" // Type inferred as String
  case _ => "Unknown type" // Type inferred as String
}
val life = describe(42)
println(life) // Output: Int: 42
assert(true, life.isInstanceOf[Int])

val simple = describe("Scala")
println(simple) // Output: String: Scala
assert(true, simple.isInstanceOf[String])

val pi_ = describe(3.14)
println(pi_) // Output: Unknown type
assert(true, pi_.isInstanceOf[Any])

//----------------------------------------------------------------------------//

//Example 6: Type Inference with for-Comprehensions
val numbers6 = List(1, 2, 3, 4)
val doubled6 = for (n <- numbers6) yield n * 2 // Type inferred as List[Int]
println(doubled6) // Output: List(2, 4, 6, 8)
assert(true, doubled6.isInstanceOf[List[Int]])

//----------------------------------------------------------------------------//

//Example 7: Type Inference in Anonymous Functions
val increment: Int => Int = x => x + 1 // Type inferred as Int => Int
assert(true, increment.isInstanceOf[Int])

val concatenate: (String, String) => String = (a, b) => a + b // Type inferred as (String, String) => String
assert(true, concatenate.isInstanceOf[(String, String)])

//----------------------------------------------------------------------------//

//Example 8: Type Inference with Case Classes
case class Person(name: String, age: Int)
val people = List(Person("Alice", 30), Person("Bob", 25), Person("Charlie", 35)) // Type inferred as List[Person]
for (Person(name, age) <- people) {
  println(s"$name is $age years old")
  assert(true, name.isInstanceOf[String])
  assert(true, age.isInstanceOf[Int])
}

// Output:
// Alice is 30 years old
// Bob is 25 years old
// Charlie is 35 years old