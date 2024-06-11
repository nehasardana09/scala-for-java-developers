package com.scala.examples.companion

// Define a class with a private constructor
class Person private(val name: String, val age: Int)

// Define the companion object
object Person {
  // Factory method to create a Person instance
  def apply(name: String, age: Int): Person = new Person(name, age)
}

// Main application
object MainApp extends App {
  // Use the factory method in the companion object to create an instance
  val person = Person("Alice", 30)
  println(s"Name: ${person.name}, Age: ${person.age}")
}
