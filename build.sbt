name := """E71Project"""

version := "1.0"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  evolutions,
  cache,
  javaWs,
  "com.adrianhurt" %% "play-bootstrap" % "1.0-P25-B3",
  "mysql" % "mysql-connector-java" % "5.1.28"
)

