package com.shashank.implicits.extending_types

import com.shashank.implicits.datatype_conversions.User
import com.shashank.implicits.extending_types.TypeExtensionImplicits.toJsonUser
/**
  * Created by shashank on 23/07/2017.
  */
object ExplicitExtension {

  def main(args: Array[String]) {
    val user = User("testuser", "testuser@gmail.com", isAdmin = true)
    println(user)
    println(user.asJsObject.prettyPrint)

  }

}
