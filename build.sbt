name := "going-functional-with-scala"

version := "0.1"

scalaVersion := "2.12.10"

scalacOptions += "-Ypartial-unification"

val catsDependencies = Seq("org.typelevel" %% "cats-core" % "2.0.0", "org.typelevel" %% "cats-effect" % "1.2.0")
libraryDependencies ++= catsDependencies
