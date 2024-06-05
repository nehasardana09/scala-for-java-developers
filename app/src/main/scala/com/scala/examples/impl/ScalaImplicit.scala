package com.scala.examples.impl


// Define a simple configuration class
case class Config(databaseUrl: String)

// A function that requires a Config implicitly
def connectToDatabase()(implicit config: Config): Unit = {
  println(s"Connecting to database at: ${config.databaseUrl}")
}

// Define an implicit instance of Config
implicit val defaultConfig: Config = Config("jdbc://localhost:5432/mydb")

// Call the function without explicitly passing the implicit parameter
@main def run(): Unit = {
  connectToDatabase() // Output: Connecting to database at: jdbc://localhost:5432/mydb
}