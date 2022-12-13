name := "in-class-code"

version := "2.0"

scalaVersion := "3.1.3"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.13"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.13" % "test"
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.7.0"

Test / parallelExecution := false
