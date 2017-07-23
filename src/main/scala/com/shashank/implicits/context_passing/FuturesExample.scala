package com.shashank.implicits.context_passing

import scala.concurrent.{ExecutionContext, Future}
import java.util.Date
import java.util.concurrent.Executor
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by shashank on 23/07/2017.
  */
object FuturesExample {

  def main(args: Array[String]) {

    println(s"Starting the job ${new Date()}")
    val firstOccurrence: Future[Int] = Future {
      val source = scala.io.Source.fromFile("/Users/shashank/Tellius/resources/datasets/Airlines delay data/2007.csv")
      source.toSeq.indexOfSlice("N628DL")
    }

    firstOccurrence.onComplete(valueTry => {
      println(s"Completed the job ${new Date()}")
      println(s"Firse occurence of word abc is ${valueTry.get}")
    })

    println(s"Waiting for results ${new Date()}")
    Thread.sleep(20000)
  }

}
