package com.shashank.implicits.context_passing

import java.util.Date
import java.util.concurrent.Executor
import scala.concurrent.{ExecutionContext, Future}

/**
  * Created by shashank on 23/07/2017.
  */
object FuturesExampleSameThread {

  def main(args: Array[String]) {
    implicit val currentThreadExecutionContext = ExecutionContext.fromExecutor(
      new Executor {
        // Do not do this!
        def execute(runnable: Runnable) { runnable.run() }
      })

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
  }

}
