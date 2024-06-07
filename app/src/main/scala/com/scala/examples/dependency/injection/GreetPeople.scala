package com.scala.examples.dependency.injection

trait GreetingService {
  def greet(name: String): String
}

trait TimeService {
  def getCurrentTime: String
}

//Implementations
trait GreetingServiceImpl extends GreetingService {
  def greet(name: String): String = s"Hello, $name!"
}

trait TimeServiceImply extends TimeService {
   def getCurrentTime: String = java.time.LocalTime.now().toString
}

class Greeter {
  this: GreetingService with TimeService =>

  def greetWithTime(name: String): String = {
    val greeting = greet(name)
    val time = getCurrentTime
    s"$greeting The current time is $time"
  }
}


object GreetPeople {
  @main def run(): Unit = {
    val greeter = new Greeter with GreetingServiceImpl with TimeServiceImply
    println(greeter.greetWithTime("Scala"))
  }
}
