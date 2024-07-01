package com.scala.examples

object ImmutableExample extends App{
  
  val youCannotChangeMe = 5
  var changeMe = 10
  print(s"The value of variable youCannotChangeMe: $youCannotChangeMe" )
  print(s"The value of variable changeMe: $changeMe")
 //youCannotChangeMe = youCannotChangeMe+1 //compiler error
  

}
