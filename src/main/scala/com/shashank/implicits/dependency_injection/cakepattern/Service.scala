package com.shashank.implicits.dependency_injection.cakepattern

/**
  * Created by shashank on 20/07/2017.
  */

trait UserService {
  def authenticate(username: String, password: String): Boolean

  def create(username: String, password: String, email:String): Option[String]

  def delete(username: String): Boolean

}

trait UserServiceComponent { this: UserRepositoryComponent =>
  val userService:UserService

  class UserServiceImpl extends UserService {
    def authenticate(username: String, password: String): Boolean = {
      userRepository.get(username) match {
        case Some(user) if user.password == password => true
        case _ => false
      }
    }

    def delete(username: String): Boolean =  userRepository.delete(username)

    def create(username: String, password: String, email:String): Option[String] = {
      userRepository.create(User(username, password, email)).map(_.username)
    }
  }
}
