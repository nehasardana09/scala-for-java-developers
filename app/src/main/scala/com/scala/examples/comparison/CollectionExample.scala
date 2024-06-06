package com.scala.examples.comparison

object CollectionExample {
  def main(args: Array[String]): Unit = {
    val doubled = (1 to 5).map(_ * 2)
    println(s"Doubled numbers: $doubled")
  }
}
