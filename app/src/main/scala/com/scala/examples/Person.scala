package com.scala.examples

class Person(val name: String, val age: Int) {
  def greet(): String = s"Hello, my name is $name and I am $age years old."
}

object PersonApp {
  def main(args: Array[String]): Unit = {
    val person = new Person("Alice", 30)
    println(person.greet())
  }
}
