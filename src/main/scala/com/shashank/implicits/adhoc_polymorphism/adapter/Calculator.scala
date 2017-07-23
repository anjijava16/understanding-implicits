package com.shashank.implicits.adhoc_polymorphism.adapter

/**
  * Created by shashank on 23/07/2017.
  */

import Statistics.{NumberLikeDouble, NumberLikeInt}

object Calculator {

  def main(args: Array[String]) {

    val doubleNumbers = Vector(NumberLikeDouble(13), NumberLikeDouble(23.0), NumberLikeDouble(42),
                                 NumberLikeDouble(45), NumberLikeDouble(61), NumberLikeDouble(73))
    println(Statistics.mean(doubleNumbers))

    val intNumbers = Vector(NumberLikeInt(13), NumberLikeInt(23), NumberLikeInt(42),
                            NumberLikeInt(45), NumberLikeInt(61), NumberLikeInt(73))
    println(Statistics.mean(intNumbers))

  }

}
