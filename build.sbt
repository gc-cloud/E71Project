name := """E71Project"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs
//  "mysql" % "mysql-connector-java" % "5.7.16" // Driver  needed if we use MySQL
)

