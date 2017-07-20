package com.shashank.implicits.dependency_injection.cakepattern

/**
  * Created by shashank on 20/07/2017.
  */

trait UserAuthorizationComponent {
  def userAuthorization: UserAuthorization

  trait UserAuthorization {
    def authorize(username: String):Boolean
  }
}

// Component implementation
trait UserAuthorizationComponentImpl extends UserAuthorizationComponent {

  this: UserRepositoryComponent =>

  def userAuthorization = new UserAuthorizationImpl

  class UserAuthorizationImpl extends UserAuthorization {
    def authorize(username: String):Boolean = {
      println("Authorizing " + username)
      val status = userRepository.get(username).get.isAdmin//.getOrElse(false)
      println(s"Authorization status for $username is $status" )
      status
    }
  }
}
