name := "going-functional-with-scala"

version := "0.1"

scalaVersion := "2.13.7"

val catsDependencies = Seq(
  "org.typelevel" %% "cats-core" % "2.7.0",
  "org.typelevel" %% "cats-effect" % "3.3.4",
  "org.scalatest" %% "scalatest" % "3.2.10" % Test
)
libraryDependencies ++= catsDependencies
