name := "cpi-stats"

organization := "com.PhysicsEngine"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.10.2"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "1.13" % "test"
)


libraryDependencies  ++= Seq(
            // other dependencies here
            // pick and choose:
            "org.scalanlp" % "breeze-math_2.10" % "0.3",
            "org.scalanlp" % "breeze-learn_2.10" % "0.3",
            "org.scalanlp" % "breeze-process_2.10" % "0.3",
            "org.scalanlp" % "breeze-viz_2.10" % "0.3"
)

resolvers ++= Seq(
            // other resolvers here
            // if you want to use snapshot builds (currently 0.5-SNAPSHOT), use this.
            "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
            "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/releases/"
)

resolvers += "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"

libraryDependencies += "com.github.tototoshi" %% "scala-csv" % "1.0.0-SNAPSHOT"

initialCommands := "import com.PhysicsEngine.cpistats._"
