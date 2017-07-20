name := "UnderstandingImplicits"

version := "1.0"

scalaVersion := "2.11.8"

val sparkVersion = "2.1.0"


resolvers ++= Seq(
  "apache-snapshots" at "http://repository.apache.org/snapshots/",
  "oss-sonatype" at "https://oss.sonatype.org/content/repositories/snapshots/",
  "conjars repo" at "http://conjars.org/repo",
  "clojars" at "http://clojars.org/repo"
)

libraryDependencies ++= Seq(
  "org.mongodb" %% "casbah" % "2.8.2"
  /*"org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.apache.spark" %% "spark-mllib" % sparkVersion,
  "org.apache.spark" %% "spark-streaming" % sparkVersion,
  "org.apache.spark" %% "spark-hive" % sparkVersion*/
)
    
