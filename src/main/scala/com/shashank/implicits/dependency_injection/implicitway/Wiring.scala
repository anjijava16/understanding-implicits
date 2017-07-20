package com.shashank.implicits.dependency_injection.implicitway

import com.shashank.implicits.dependency_injection.cakepattern.{User, _}

/**
  * Created by shashank on 20/07/2017.
  */
object InMemoryStorageService extends UserAuthorizationImpl with UserRepositoryComponentInMemoryImpl{

  def main(args: Array[String]) {
    implicit val userRepo = userRepository
    userRepository.put(User("testuser", "testuser@gmail.com", isAdmin = true))
    val authStatus = authorize("testuser")
    println(authStatus)
  }

}

object MongoStorageService extends UserAuthorizationImpl with UserRepositoryComponentMongodbImpl {

  def main(args: Array[String]) {
    implicit val userRepo = userRepository
    if(userRepository.get("testuser").isEmpty)
      userRepository.put(User("testuser", "testuser@gmail.com", isAdmin = true))
    val authStatus = authorize("testuser")
    println(authStatus)
  }

}
