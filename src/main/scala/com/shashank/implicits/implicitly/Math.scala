package com.shashank.implicits.implicitly

/**
  * Created by shashank on 23/07/2017.
  */

object Math {

  trait NumberLike[T] {
    def plus(x: T, y: T): T
    def divide(x: T, y: Int): T
    def minus(x: T, y: T): T
    def max(x:T, y:T): T
    def min(x:T, y:T): T
  }

  object NumberLike {

    implicit object NumberLikeDouble extends NumberLike[Double] {
      def plus(x: Double, y: Double): Double = x + y
      def divide(x: Double, y: Int): Double = x / y
      def minus(x: Double, y: Double): Double = x - y
      def max(x: Double, y: Double): Double = if(x > y) x else y
      def min(x:Double, y:Double): Double = if(x > y) y else x
    }

    implicit object NumberLikeInt extends NumberLike[Int] {
      def plus(x: Int, y: Int): Int = x + y
      def divide(x: Int, y: Int): Int = x / y
      def minus(x: Int, y: Int): Int = x - y
      def max(x: Int, y: Int): Int = if(x > y) x else y
      def min(x: Int, y: Int): Int = if(x > y) y else x
    }
  }

}
