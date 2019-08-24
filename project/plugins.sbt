// https://mvnrepository.com/artifact/org.postgresql/postgresql
libraryDependencies += "org.postgresql" % "postgresql" % "42.2.6"


addSbtPlugin("com.typesafe.sbt" % "sbt-twirl" % "1.3.13")
addSbtPlugin("org.scalatra.sbt" % "sbt-scalatra" % "1.0.2")
addSbtPlugin("org.scalikejdbc" %% "scalikejdbc-mapper-generator" % "3.3.5")