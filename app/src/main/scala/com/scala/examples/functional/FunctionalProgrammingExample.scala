package com.scala.examples.functional

object FunctionalProgrammingExample extends App {
  // List of numbers
  val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

  // Using a function to filter even numbers
  val isEven: Int => Boolean = _ % 2 == 0
  val evenNumbers = numbers.filter(isEven)

  // Using a function to double the numbers
  val doubleNumber: Int => Int = _ * 2
  val doubledNumbers = evenNumbers.map(doubleNumber)

  // Printing the numbers using a foreach loop
  doubledNumbers.foreach(println)

  // Combining all operations in a single chain
  val result = numbers.filter(isEven).map(doubleNumber)

  println(s"Result: $result")
}
