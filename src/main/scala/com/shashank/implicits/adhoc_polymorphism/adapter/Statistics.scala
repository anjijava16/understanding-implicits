package com.shashank.implicits.adhoc_polymorphism.adapter

/**
  * Created by shashank on 23/07/2017.
  */

object Statistics {

  trait NumberLike[A] {
    def get: A
    def plus(y: NumberLike[A]): NumberLike[A]
    def minus(y: NumberLike[A]): NumberLike[A]
    def divide(y: Int): NumberLike[A]
  }

  case class NumberLikeDouble(x: Double) extends NumberLike[Double] {
    def get: Double = x
    def minus(y: NumberLike[Double]) = NumberLikeDouble(x - y.get)
    def plus(y: NumberLike[Double]) = NumberLikeDouble(x + y.get)
    def divide(y: Int) = NumberLikeDouble(x / y)
  }

  case class NumberLikeInt(x: Int) extends NumberLike[Int] {
    def get: Int = x
    def minus(y: NumberLike[Int]) = NumberLikeInt(x - y.get)
    def plus(y: NumberLike[Int]) = NumberLikeInt(x + y.get)
    def divide(y: Int) = NumberLikeInt(x/y)
  }

  def median[A](xs: Vector[NumberLike[A]]): NumberLike[A] = xs(xs.size / 2)

  def mean[A](xs: Vector[NumberLike[A]]): NumberLike[A] =
    xs.reduce(_.plus(_)).divide(xs.size)

}