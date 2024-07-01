package com.scala.examples

import java.util.ArrayList
import scala.jdk.CollectionConverters._

object JavaInteropExample {
  def main(args: Array[String]): Unit = {
    // Create an instance of Java's ArrayList
    val javaList = new ArrayList[String]()

    // Add elements to the Java ArrayList
    javaList.add("Apple")
    javaList.add("Banana")
    javaList.add("Cherry")

    // Print the Java ArrayList
    println("Java ArrayList: " + javaList)

    // Convert Java ArrayList to Scala List
    val scalaList = javaList.asScala.toList

    // Perform operations using Scala collection methods
    val upperCaseList = scalaList.map(_.toUpperCase)
    println("Scala List (upper case): " + upperCaseList)

    val filteredList = scalaList.filter(_.startsWith("A"))
    println("Filtered Scala List (starts with 'A'): " + filteredList)
  }
}
