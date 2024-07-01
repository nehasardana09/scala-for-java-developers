package com.scala.examples.traits

object StatefulTraits {

  @main def run(): Unit = {
    val service = new Service
    service.doSomething()
  }


}

trait Logger{
  def log(msg: String) : Unit = println(msg)
}

trait TimestampLogger extends Logger {
  override def log(msg: String): Unit = super.log(s" $msg at : ${java.time.Instant.now()}")
}

class Service extends Logger with TimestampLogger {
  def doSomething(): Unit = log("Doing Something")
}

