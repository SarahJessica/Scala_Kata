import sbt._
import sbt.{Build => SbtBuild}
import sbt.Keys._
import sbtassembly.Plugin.AssemblyKeys._
import templemore.sbt.cucumber.CucumberPlugin


object Build extends SbtBuild {

  val Organization = "london.sarahjessica"
  val Name = "kata"
  val Version = Option(System.getenv("BUILD_VERSION")) getOrElse "DEV"
  val ScalaVersion = "2.11.8"

  val JettyPort = sys.props.get("jetty.port") map (_.toInt) getOrElse 8080

  val dependencies = Seq(

    // test
    "org.scalatest" %% "scalatest" % "3.0.0" % "test",
//    "com.novocode" %% "junit-interface" % "0.9" % "test",
    "org.mockito" % "mockito-core" % "1.9.5" % "test",
    "info.cukes" %% "cucumber-scala" % "1.2.4" % "compile,test"


    // jetty
//    "org.eclipse.jetty" % "jetty-webapp" % "9.4.0.M0" % "container;compile"
  )

  lazy val project = Project(
    Name,
    file("."),
    settings =
      Defaults.coreDefaultSettings ++
        Seq(CucumberPlugin.cucumberSettings: _*) ++
        Seq(
          CucumberPlugin.cucumberFeaturesLocation := "cucumber",
          CucumberPlugin.cucumberJsonReport := true,
          CucumberPlugin.cucumberStepsBasePackage := "steps",
          unmanagedResourceDirectories in Compile <+= baseDirectory(_ / "test/fixtures")
        ) ++
        Seq(scalacOptions ++= Seq("-feature", "-target:jvm-1.7", "-language:implicitConversions")) ++
        Seq(
          organization := Organization,
          name := Name,
          version := Version,
          resolvers += Classpaths.typesafeReleases,
          jarName in assembly := s"$Name.jar",
          mainClass in assembly := Some("Launcher"),
          libraryDependencies ++= dependencies
        ) ++
        Seq(
          resolvers += "Local Ivy repository" at "file://" + Path.userHome + "/.ivy2/local",
          resolvers += "BBC Forge Maven Releases" at "https://dev.bbc.co.uk/maven2/releases/",
          resolvers += "BBC Forge Maven Snapshots" at "https://dev.bbc.co.uk/maven2/snapshots",
          resolvers += "BBC Forge Artifactory" at "https://dev.bbc.co.uk/artifactory/repo",
          resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
        )
  )
}
