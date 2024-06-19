package com.scala.examples

class TailRecursion {

  import scala.annotation.tailrec

  object TailRecursionExample {
    def main(args: Array[String]): Unit = {
      println(factorial(5)) // Output: 120
    }

    // @tailrec annotation ensures that the factorial method is tail-recursive.
    // If the method is not tail-recursive, the compiler will throw an error.
    // Ensures that your recursive functions are optimized to prevent stack overflow errors, making tail recursion a practical approach. 
    // This leverages the functional programming features of Scala, enabling elegant and efficient recursive solutions.
    @tailrec
    private def factorial(n: Int, acc: Int = 1): Int = {
      if (n == 0) acc
      else factorial(n - 1, n * acc)
    }
  }

  object IterativeExample {
    def main(args: Array[String]): Unit = {
      println(factorial(5)) // Output: 120
    }

    private def factorial(n: Int): Int = {
      // Uses mutable variables acc and i to perform the iteration, which 
      // is more idiomatic in imperative programming but less so in functional programming.
      var acc = 1
      var i = n
      while (i > 0) {
        acc *= i
        i -= 1
      }
      acc
    }
  }


}
