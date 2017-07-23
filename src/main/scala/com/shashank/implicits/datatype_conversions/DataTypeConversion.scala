package com.shashank.implicits.datatype_conversions

import spray.json._




object DataTypeConversion {

  def main(args: Array[String]) {

    val user = User("testuser", "testuser@gmail.com", isAdmin = true)
    println(user)
    println(ConversionImplicits.userToJsObject(user).prettyPrint)

  }

}
