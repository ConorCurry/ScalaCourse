lazy val root = (project in file("."))
  .settings(
    name := "Week1",
    scalaVersion := "2.12.3",
    version := "0.13.13",
    libraryDependencies += "org.scalatest" % "scalatest_2.11" % "3.0.1" % "test",
    libraryDependencies += "junit" % "junit" % "4.10" % Test,
  )

