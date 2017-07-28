package com.shashank.implicits.implicit_class

import com.shashank.implicits.datatype_conversions.User

/**
  * Created by shashank on 28/07/2017.
  */
object LateTraitImplementation {
  implicit class UserOrdering(user: User) extends Ordered[User] {
    override def compare(that: User): Int = user.userId.compare(that.userId)
  }
}
