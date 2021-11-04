name := "going-functional-with-scala"

version := "0.1"

scalaVersion := "2.13.7"

val catsDependencies = Seq(
  "org.typelevel" %% "cats-core" % "2.6.1",
  "org.typelevel" %% "cats-effect" % "2.5.4",
  "org.scalatest" %% "scalatest" % "3.2.10" % Test
)
libraryDependencies ++= catsDependencies
