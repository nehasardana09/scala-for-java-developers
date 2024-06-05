package com.scala.examples

@main def run(): Unit =
  val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  val sum = numbers.filter(_ % 2 == 0).sum
  println(s"Sum of even numbers: $sum")
