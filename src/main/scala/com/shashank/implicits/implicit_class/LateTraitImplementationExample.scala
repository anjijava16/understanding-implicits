package com.shashank.implicits.implicit_class

import com.shashank.implicits.datatype_conversions.User

/**
  * Created by shashank on 28/07/2017.
  */
object LateTraitImplementationExample {

  def main(args: Array[String]) {
    val user1 = User("123", "testuser@gmail.com", isAdmin = true)
    val user2 = User("453", "testuser@gmail.com", isAdmin = true)
    val user3 = User("323", "testuser@gmail.com", isAdmin = true)
    val user4 = User("023", "testuser@gmail.com", isAdmin = true)

    import LateTraitImplementation._
    List(user1, user2, user3, user4).sorted.foreach(println)

  }

}
