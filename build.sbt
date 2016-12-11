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
  "mysql" % "mysql-connector-java" % "5.1.28",
  "it.innove" % "play2-pdf" % "1.5.1",
  "org.pac4j" % "play-pac4j" % "2.6.0",
  "org.pac4j" % "pac4j-http" % "1.9.4",
  "org.pac4j" % "pac4j-oauth" % "1.9.4",
  "org.pac4j" % "pac4j-oidc" % "1.9.4" exclude("commons-io" , "commons-io"),
  "org.pac4j" % "pac4j-jwt" % "1.9.4" exclude("commons-io" , "commons-io"),
  "commons-io" % "commons-io" % "2.4",
  "be.objectify" %% "deadbolt-java" % "2.5.1"

)

