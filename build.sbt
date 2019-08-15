val ScalatraVersion = "2.7.0-RC1"
val oktaVersion = "0.4.0"

organization := "org.scalatra"

name := "Back End"

version := "0.1.0-SNAPSHOT"


scalaVersion := "2.12.8"

resolvers += Classpaths.typesafeReleases

libraryDependencies ++= Seq(
  "org.scalatra" %% "scalatra" % ScalatraVersion,
  "org.scalatra" %% "scalatra-scalatest" % ScalatraVersion % "test",
  "org.scalatra" %% "scalatra-json" % ScalatraVersion,
  "org.scalatra" %% "scalatra-swagger" % ScalatraVersion,
  "org.json4s"   %% "json4s-jackson" % "3.6.7",
  "ch.qos.logback" % "logback-classic" % "1.2.3" % "runtime",
  "org.eclipse.jetty" % "jetty-webapp" % "9.4.9.v20180320" % "container",
  "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
  "com.okta.jwt" % "okta-jwt-verifier" % oktaVersion,
  "com.okta.jwt" % "okta-jwt-verifier-impl" % oktaVersion % "runtime",
  "com.typesafe" % "config" % "1.3.2",
  "ch.qos.logback" % "logback-classic" % "1.2.3" % "runtime",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",

)

enablePlugins(SbtTwirl)
enablePlugins(ScalatraPlugin)
