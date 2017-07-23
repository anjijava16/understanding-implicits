package com.shashank.implicits.adhoc_polymorphism.typeclasses

/**
  * Created by shashank on 23/07/2017.
  */

import Math.NumberLike

object Statistics {

  def mean[T](xs: Vector[T])(implicit ev: NumberLike[T]): T = ev.divide(xs.reduce(ev.plus(_, _)), xs.size)

  def median[T](xs: Vector[T])(implicit ev: NumberLike[T]): T =
    xs(xs.size / 2)

}