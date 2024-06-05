package com.scala.examples

trait Animal {
  def sound(): String
}

class Dog extends Animal {
  override def sound(): String = "Woof"
}

object TraitExample {
  def main(args: Array[String]): Unit = {
    val dog = new Dog()
    println(s"The dog says: ${dog.sound()}")
  }
}
