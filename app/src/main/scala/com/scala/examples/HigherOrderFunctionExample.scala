package com.scala.examples

object HigherOrderFunctionExample {
  private def applyOperation(a: Int, b: Int, operation: (Int, Int) => Int): Int = {
    operation(a, b)
  }

  def main(args: Array[String]): Unit = {
    val sum = applyOperation(3, 4, _ + _)
    println(s"Sum: $sum")
  }
}
