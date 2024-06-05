package com.scala.examples

import scala.concurrent.{Future, Await}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object FutureExample {
  def main(args: Array[String]): Unit = {
    val future = Future {
      Thread.sleep(1000)
      42
    }

    future.onComplete {
      case scala.util.Success(value) => println(s"Future completed with value: $value")
      case scala.util.Failure(exception) => println(s"Future failed with exception: $exception")
    }

    Await.result(future, 2.seconds) // This line is only for demo purposes to wait for the future to complete
  }
}
