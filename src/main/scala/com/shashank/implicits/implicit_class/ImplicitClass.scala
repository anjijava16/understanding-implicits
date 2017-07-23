package com.shashank.implicits.implicit_class

import com.shashank.implicits.datatype_conversions.User
import com.shashank.implicits.extending_types.TypeExtensionImplicits
import spray.json.{JsBoolean, JsObject, JsString}

/**
  * Created by shashank on 23/07/2017.
  */
object ImplicitClass {

  implicit class JsonUser(user:User){
    def asJsObject: JsObject = TypeExtensionImplicits.userToJsObject(user)
  }

}
