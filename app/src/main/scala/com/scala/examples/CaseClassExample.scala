package com.scala.examples

case class Book(title: String, author: String)

object CaseClassExample {
  @main
  def entryPoint(): Unit = {
    val book = Book("1984", "George Orwell")
    println(s"Book title: ${book.title}, Author: ${book.author}")
  }
}
