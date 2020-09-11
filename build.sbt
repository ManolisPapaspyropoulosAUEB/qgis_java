name := """app"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  javaCore,
  javaJpa,
  "mysql" % "mysql-connector-java" % "5.1.38",
  "org.hibernate" % "hibernate-entitymanager" % "3.6.10.Final", // replace by your jpa implementation
  "org.apache.commons" % "commons-email" % "1.5",
  "net.sf.jasperreports" % "jasperreports" % "4.0.1",
  "commons-digester" % "commons-digester" % "1.7",
  "com.lowagie" % "itext" % "2.1.7",
  "net.sourceforge.jexcelapi" % "jxl" % "2.6.10",
  "org.codehaus.groovy" % "groovy-all" % "1.7.5",
  "org.apache.poi" % "poi" % "3.8",
  "org.apache.poi" % "poi-ooxml" % "3.9",
  "org.mindrot" % "jbcrypt" % "0.3m",
  "com.cloudinary" % "cloudinary-http44" % "1.26.0",
  "com.auth0" % "java-jwt" % "3.10.3",
  "org.modelmapper" % "modelmapper" % "2.3.0"

)
resolvers += Resolver.url("Objectify Play Repository", url("http://schaloner.github.com/releases/"))(Resolver.ivyStylePatterns)
//routesGenerator := StaticRoutesGenerator

libraryDependencies += filters
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.6.0"
