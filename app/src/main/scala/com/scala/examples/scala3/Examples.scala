package com.scala.examples.scala3

object Examples {
  opaque type UserID = Int // Opaque type alias
  def getUserId: UserID = 12345 //Opaque type

  @main
  def run(): Unit = {
    // Optional braces
    def add(x: Int, y: Int): Int = x + y

    // Top-level definitions
    val greeting = "Hello, World"
    def sayHello(name: String): String = s"$greeting, $name"

    val list = List(1, 2, 3) // No need to specify the type of the list elements
    val result = list.map(_ * 2) // Type of result is inferred as List[Int]

    type UserName = String
    type UserAge = Int
    type User = UserName | UserAge // Union type
    type Container[T] = List[T] & Cloneable // Intersection type
  }
}
//Enums and sealed
enum Color {
  case Red, Green, Blue
}

sealed trait Shape
case class Circle(radius: Double) extends Shape
case class Square(side: Double) extends Shape

//Contextual Abstractions (Given and Using Clauses, Extension Methods)
given orderingInt: Ordering[Int] = Ordering.fromLessThan(_ > _)
def maxList[T](list: List[T])(using ord: Ordering[T]): T = list.max
extension (s: String)
  def toIntOpt: Option[Int] = s.toIntOption

//MetaProgramming
inline def assert(condition: => Boolean): Unit = if !condition then throw new AssertionError("Assertion failed")

type Element[X] = X match
  case String => Char
  case Array[t] => t
  case Iterable[t] => t

def test(x: Any): String = x match
  case s: String => s"string $s"
  case n: Int => s"int $n"
  case _ => "unknown"

trait Greeting(name: String) {
  def greet: String = s"Hello, $name"
}



