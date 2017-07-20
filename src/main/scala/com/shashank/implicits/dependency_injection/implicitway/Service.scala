package com.shashank.implicits.dependency_injection.implicitway

import com.shashank.implicits.dependency_injection.cakepattern.UserRepository

/**
  * Created by shashank on 20/07/2017.
  */

trait UserAuthorization {
  def authorize(username: String)(implicit userRespository:UserRepository):Boolean
}

// Component implementation
trait UserAuthorizationImpl extends UserAuthorization {

  def authorize(username: String)(implicit userRespository:UserRepository):Boolean = {
    println("Authorizing " + username)
    val status = userRespository.get(username).get.isAdmin//.getOrElse(false)
    println(s"Authorization status for $username is $status" )
    status
  }
}
