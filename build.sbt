import AssemblyKeys._  
assemblySettings 

name := "LearnSpark"

version := "1.0"

//scalaVersion := System.getenv.get("SCALA_VERSION")
scalaVersion := "2.10.5"

EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource

//libraryDependencies += "org.apache.spark" %% "spark-core" % System.getenv.get("SPARK_VERSION")

//libraryDependencies += "org.apache.spark" %% "spark-ganglia-lgpl" % System.getenv.get("SPARK_VERSION")

//resolvers ++= Seq(
//  "Spark Release Repository" at System.getenv.get("SPARK_RELEASE_REPOSITORY"),
//  "Spray Repository" at "http://repo.spray.cc/")
