name := "Mailer"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "org.apache.commons" % "commons-email" % "1.3.1"
)     

play.Project.playScalaSettings
