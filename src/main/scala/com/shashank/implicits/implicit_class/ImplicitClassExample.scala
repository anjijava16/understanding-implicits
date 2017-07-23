package com.shashank.implicits.implicit_class

import com.shashank.implicits.datatype_conversions.User

/**
  * Created by shashank on 23/07/2017.
  */
object ImplicitClassExample {

  def main(args: Array[String]) {
    val user = User("testuser", "testuser@gmail.com", isAdmin = true)
    println(user)

    import ImplicitClass._
    println(user.asJsObject.prettyPrint)
  }

}
