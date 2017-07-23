package com.shashank.implicits.extending_types

import com.shashank.implicits.datatype_conversions.User
import spray.json.{JsBoolean, JsObject, JsString}


/**
  * Created by shashank on 23/07/2017.
  */
object ImplicitConversion {

  def main(args: Array[String]) {
    import TypeExtensionImplicits.userToJsObject
    val user = User("testuser", "testuser@gmail.com", isAdmin = true)
    println(user)
    println(user.prettyPrint)

  }

}


