package com.shashank.implicits.dependency_injection.implicitway

/**
  * Created by shashank on 20/07/2017.
  */

class UserService {

  def authenticate(username: String, password: String)(implicit userRepository:UserRepository): Boolean = {
    userRepository.get(username) match {
      case Some(user) if user.password == password => true
      case _ => false
    }
  }

  def delete(username: String)(implicit userRepository:UserRepository): Boolean =  userRepository.delete(username)

  def create(username: String, password: String, email:String)(implicit userRepository:UserRepository): Option[String] = {
    userRepository.create(User(username, password, email)).map(_.username)
  }

}
