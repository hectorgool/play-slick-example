name := """play-slick-example"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test,
  "com.typesafe.play"    %% "play-slick"            % "1.1.1",
  "mysql"                 % "mysql-connector-java"  % "5.1.38",
	"com.github.tototoshi" %% "slick-joda-mapper"     % "2.1.0",
  "joda-time"             % "joda-time"             % "2.7",
  "org.joda"              % "joda-convert"          % "1.7"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

libraryDependencies += evolutions
