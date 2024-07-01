import org.gradle.api.logging.LogLevel
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.api.tasks.scala.ScalaCompile
import org.gradle.api.tasks.Exec


plugins {
    // Apply the scala Plugin to add support for Scala.
    scala
    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    implementation("org.scala-lang:scala3-library_3:3.0.0")
    testImplementation("org.scalatest:scalatest_3:3.2.10")
    testImplementation("org.scalatestplus:junit-4-13_3:3.2.10.0")
    testImplementation("junit:junit:4.13.2")
}


application {
    // Define the main class for the application.
    mainClass.set("com.scala.examples.App")
}


tasks.withType<JavaCompile> {
    logging.captureStandardOutput(LogLevel.QUIET)
    logging.captureStandardError(LogLevel.QUIET)
}

tasks.withType<ScalaCompile> {
    logging.captureStandardOutput(LogLevel.QUIET)
    logging.captureStandardError(LogLevel.QUIET)
}

tasks.withType<JavaExec> {
    logging.captureStandardOutput(LogLevel.QUIET)
    logging.captureStandardError(LogLevel.QUIET)
}

tasks.register<Exec>("runQuietly") {
    commandLine("gradle", "app:run", "--quiet")
}
tasks.withType<ScalaCompile> {
    scalaCompileOptions.debugLevel = "error"
    scalaCompileOptions.forkOptions.jvmArgs = listOf("-Xmx2G", "-Xms1G")
}

tasks.test {
    useTestNG()
}




