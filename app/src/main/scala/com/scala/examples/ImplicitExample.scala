package com.scala.examples

object ImplicitExample {
  def multiply(implicit factor: Int): Int = 10 * factor

  def main(args: Array[String]): Unit = {
    implicit val multiplier: Int = 5
    println(s"Result: ${multiply}")
  }
}
