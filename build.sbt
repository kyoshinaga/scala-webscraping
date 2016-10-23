import AssemblyKeys._

assemblySettings

name := "scala-webscraping"

version := "0.0"

fork in run := true

scalaVersion := "2.11.8"

mainClass in assembly := Some("scalaScraping.ScalaHtml")

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.11" % "test",
  "com.novocode" % "junit-interface" % "0.10-M4" % "test->default",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test",
  "com.ibm.icu" % "icu4j" % "49.1"
)
