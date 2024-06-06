package com.scala.examples.comparison

sealed trait MyData
case class Text(s: String) extends MyData
case class Number(n: Int) extends MyData

object ScalaData{
  @main
  def run2(): Unit = {
    val dataList: List[MyData] = List(Text("hello"), Number(10), Text("world"), Number(20))

    val sumNumbers = dataList.map {
      case Number(n) => n
      case _ => 0
    }.sum

    val combinedText = dataList.map {
      case Text(s) => s
      case _ => ""
    }.mkString(" ")

    println(s"Sum of numbers: $sumNumbers")
    println(s"Combined text: $combinedText")
  }
}