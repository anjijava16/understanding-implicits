package com.shashank.implicits.dependency_injection.implicitway

/**
  * Created by shashank on 20/07/2017.
  */

object UserAuthorization {

  def authorize(username: String)(implicit userRespository:UserRepository):Boolean = {
    println("Authorizing " + username)
    val status = userRespository.get(username).get.isAdmin//.getOrElse(false)
    println(s"Authorization status for $username is $status" )
    status
  }
}
