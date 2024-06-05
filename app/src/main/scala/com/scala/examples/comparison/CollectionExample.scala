package com.scala.examples.comparison

object CollectionExample {
  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3, 4, 5)
    val doubled = numbers.map(_ * 2)
    println(s"Doubled numbers: $doubled")
  }
}
