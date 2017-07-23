package com.shashank.implicits.datatype_conversions

import ConversionImplicits.userToJsObject

/**
  * Created by shashank on 23/07/2017.
  */
object DataTypeImplicitConversion {

  def main(args: Array[String]) {
    val user = User("testuser", "testuser@gmail.com", isAdmin = true)
    println(user)
    println(user.prettyPrint)

  }

}
