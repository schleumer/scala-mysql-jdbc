import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.4",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "ScalaMysqlJdbc",
    libraryDependencies ++= Seq(
      // Primeiramente você precisa do driver de conexão do MySQL, ele é péssimamente documentado,
      // e isso reflete também no Java.
       "mysql" % "mysql-connector-java" % "5.1.16"
    )
  )
