import AssemblyKeys._

assemblySettings

name := "scala-webscraping"

version := "0.0"

fork in run := true

scalaVersion := "2.11.8"

mainClass in assembly := Some("scalaScraping.ScalaHtml")