package com.shashank.implicits.dependency_injection.cakepattern

/**
  * Created by shashank on 20/07/2017.
  */
object InMemoryStorageService extends UserAuthorizationComponentImpl with UserRepositoryComponentInMemoryImpl{

  def main(args: Array[String]) {
    userRepository.put(User("testuser", "testuser@gmail.com", isAdmin = true))
    val authStatus = userAuthorization.authorize("testuser")
    println(authStatus)
  }

}

object MongoStorageService extends UserAuthorizationComponentImpl with UserRepositoryComponentMongodbImpl {

  def main(args: Array[String]) {
    if(userRepository.get("testuser").isEmpty)
      userRepository.put(User("testuser", "testuser@gmail.com", isAdmin = true))
    val authStatus = userAuthorization.authorize("testuser")
    println(authStatus)
  }

}
