package com.scala.examples.`type`.inference

object TypeInference {
  //Example 1: Variable Type Inference
  val message = "Hello, Scala!" // Type inferred as String
  val number = 42 // Type inferred as Int
  val pi = 3.14 // Type inferred as Double

  //Example 2: Function Return Type Inference
  def add(a: Int, b: Int) = a + b // Return type inferred as Int
  def greet(name: String) = s"Hello, $name!" // Return type inferred as String

  //Example 3: Type Inference in Collections
  val numbers = List(1, 2, 3, 4, 5) // Type inferred as List[Int]
  val words = Map("one" -> 1, "two" -> 2) // Type inferred as Map[String, Int]

  //Example 4: Type Inference with Higher-Order Functions
  val doubled = List(1, 2, 3, 4).map(x => x * 2) // Type inferred as List[Int]
  val filtered = List("apple", "banana", "cherry").filter(_.startsWith("a")) // Type inferred as List[String]

  //Example 5: Type Inference in Pattern Matching
  def describe(x: Any) = x match {
    case i: Int => s"Int: $i" // Type inferred as String
    case s: String => s"String: $s" // Type inferred as String
    case _ => "Unknown type" // Type inferred as String
  }
  println(describe(42)) // Output: Int: 42
  println(describe("Scala")) // Output: String: Scala
  println(describe(3.14)) // Output: Unknown type

  //Example 6: Type Inference with for-Comprehensions
  val numbers6 = List(1, 2, 3, 4)
  val doubled6 = for (n <- numbers6) yield n * 2 // Type inferred as List[Int]
  println(doubled6) // Output: List(2, 4, 6, 8)

  //Example 7: Type Inference in Anonymous Functions
  val increment: Int => Int = x => x + 1 // Type inferred as Int => Int
  val concatenate: (String, String) => String = (a, b) => a + b // Type inferred as (String, String) => String

  //Example 8: Type Inference with Case Classes
  case class Person(name: String, age: Int)
  val people = List(Person("Alice", 30), Person("Bob", 25), Person("Charlie", 35)) // Type inferred as List[Person]
  for (Person(name, age) <- people) {
    println(s"$name is $age years old")
  }
  // Output:
  // Alice is 30 years old
  // Bob is 25 years old
  // Charlie is 35 years old
}
