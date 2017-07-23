package com.shashank.implicits.adhoc_polymorphism.typeclasses_extension

/**
  * Created by shashank on 23/07/2017.
  */

import com.shashank.implicits.adhoc_polymorphism.typeclasses.Math.NumberLike
import com.shashank.implicits.adhoc_polymorphism.typeclasses.Statistics
import spray.json._

object JsonNumberImplicits {

  implicit object NumberLikeJsNumber extends NumberLike[JsNumber] {

    override def plus(x: JsNumber, y: JsNumber): JsNumber = JsNumber(x.value + y.value)

    override def divide(x: JsNumber, y: Int): JsNumber = JsNumber(x.value / y)

    override def minus(x: JsNumber, y: JsNumber): JsNumber = JsNumber(x.value - y.value)
  }
}


object Calculator {

  def main(args: Array[String]) {

    import JsonNumberImplicits.NumberLikeJsNumber

    val jsonNumbers:Vector[JsNumber] = Vector(JsNumber(13.0), JsNumber(23.0), JsNumber(42.0), JsNumber(45.0), JsNumber(61.0), JsNumber(73))
    println(Statistics.mean(jsonNumbers))

    println(Statistics.mean(jsonNumbers)(JsonNumberImplicits.NumberLikeJsNumber))

  }
}
