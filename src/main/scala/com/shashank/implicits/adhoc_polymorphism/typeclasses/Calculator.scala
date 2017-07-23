package com.shashank.implicits.adhoc_polymorphism.typeclasses

/**
  * Created by shashank on 23/07/2017.
  */

object Calculator {

  def main(args: Array[String]) {

    val doubleNumbers = Vector(13.0, 23.0, 42.0, 45.0, 61.0, 73)
    println(Statistics.mean(doubleNumbers))

    val intNumbers = Vector(13, 23, 42, 45, 61, 73)
    println(Statistics.mean(intNumbers))

    val stringNumbers = Vector("13", "23", "42", "45", "61", "73")
    //println(Statistics.mean(stringNumbers))

  }

}
