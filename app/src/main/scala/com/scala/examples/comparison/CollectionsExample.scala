package com.scala.examples.comparison

object CollectionsExample {
  def main(args: Array[String]): Unit = {
    val doubled = (1 to 100).map(_ * 2)
    println(s"Doubled numbers: $doubled")
  }
}
