ThisBuild / version      := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.12.18"
ThisBuild / organization := "io.sve"

lazy val baseDependencies = Seq(
  "org.apache.spark"      %% "spark-core"        % "3.3.0",
  "org.apache.spark"      %% "spark-sql"         % "3.3.0",
  // "org.apache.hadoop"     % "hadoop-client"      % "3.3.5",
  "com.chuusai"           %% "shapeless"         % "2.3.3",
  "org.scalatest"         %% "scalatest"         % "3.2.17" % Test
)

lazy val root = (project in file("."))
  .aggregate(sandbox)
  .settings(name := "newschema")

lazy val sandbox = project
  .settings(
    name := "sandbox",
    libraryDependencies ++= baseDependencies
  )
