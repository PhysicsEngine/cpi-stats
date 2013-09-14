import sbt._
import sbt.Keys._

object CpistatsBuild extends Build {

  lazy val cpistats = Project(
    id = "cpi-stats",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "cpi-stats",
      organization := "com.PhysicsEngine",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.10.2"
      // add other settings here
    )
  )
}
