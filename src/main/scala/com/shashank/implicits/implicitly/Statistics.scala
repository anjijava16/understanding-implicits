package com.shashank.implicits.implicitly

/**
  * Created by shashank on 23/07/2017.
  */

import com.shashank.implicits.implicitly.Math.NumberLike

object Statistics {

  def mean[T:NumberLike](xs: Vector[T]): T = {
    val implicitValue = implicitly[NumberLike[T]]
    implicitValue.divide(xs.reduce(implicitValue.plus(_, _)), xs.size)
  }

  def median[T:NumberLike](xs: Vector[T]): T =
    xs(xs.size / 2)

  //maxValue - minValue
  def change[T:NumberLike](xs:Vector[T]): T = {
    val implicitValue = implicitly[NumberLike[T]]
    val maxValue = xs.reduce((a, b) => implicitValue.max(a, b))
    val minValue = xs.reduce((a, b) => implicitValue.min(a, b))
    implicitValue.minus(maxValue, minValue)
  }

}