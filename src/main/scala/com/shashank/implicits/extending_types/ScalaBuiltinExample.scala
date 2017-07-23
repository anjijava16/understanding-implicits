package com.shashank.implicits.extending_types

/**
  * Created by shashank on 23/07/2017.
  */
object ScalaBuiltinExample {

  def main(args: Array[String]) {
    val javaList = new java.util.ArrayList[Int]()
    javaList.add(10)
    javaList.add(20)
    javaList.add(30)

    //println(javaList.sum)

    import scala.collection.JavaConversions._

    println(javaList.sum)

    import scala.collection.JavaConverters._

    println(javaList.asScala.sum)

  }

}
