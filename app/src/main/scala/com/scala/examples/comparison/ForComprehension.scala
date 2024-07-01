package com.scala.examples.comparison

object ForComprehension {

  @main def run(): Unit =
    println(forComprehension())
    sample()

  private def forComprehension() = {
    val y = for (x <- List(1,2,3,4)) yield (x * 2)
    y.sum
  }

  def sample(): Unit = {
    val y1 = for ( i <- 0 until 5; j = i * 3; if j % 2 == 0) yield j + 1
    //equivalent to
    val y2 = (0 until 5).map(_ * 3).filter(_ % 2 == 0).map(_ + 1)
    if y1 == y2 then println("These are equal objects")
    else println("Not equal")
  }
}
