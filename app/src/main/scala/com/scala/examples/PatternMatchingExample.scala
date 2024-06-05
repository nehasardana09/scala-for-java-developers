package com.scala.examples

object PatternMatchingExample {
  def main(args: Array[String]): Unit = {
    val day = "Monday"
    val activity = day match {
      case "Monday" => "Work"
      case "Saturday" | "Sunday" => "Relax"
      case _ => "Unknown"
    }
    println(s"Activity for $day: $activity")
  }
}
