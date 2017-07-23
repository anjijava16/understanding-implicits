package com.shashank.implicits.extending_types

import com.shashank.implicits.datatype_conversions.User
import spray.json.{JsBoolean, JsObject, JsString}

/**
  * Created by shashank on 23/07/2017.
  */
object TypeExtensionImplicits {

  implicit def userToJsObject(x: User) = JsObject(Map("userId" -> JsString(x.userId),
    "email" -> JsString(x.email),
    "isAdmin" -> JsBoolean(x.isAdmin)))

  class JsonUser(user:User) {
    def asJsObject: JsObject ={
      userToJsObject(user)
    }
  }

  implicit def toJsonUser(user:User) = new JsonUser(user)

}
