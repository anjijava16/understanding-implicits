package com.shashank.implicits.dependency_injection.implicitway

/**
  * Created by shashank on 20/07/2017.
  */
object InMemoryStorageService{

  def main(args: Array[String]) {
    implicit val userRepository = new InMemoryUserRepository
    if(userRepository.get("testuser").isEmpty) {
      userRepository.put(User("testuser", "testuser@gmail.com", isAdmin = true))
    } else {
      println("user with userId testuser already exists")
    }
    val authStatus = UserAuthorization.authorize("testuser")
    println(authStatus)
  }

}

object MongoStorageService {

  def main(args: Array[String]) {
    implicit val userRepository = new MongoDbUserRepository
    if(userRepository.get("testuser").isEmpty) {
      userRepository.put(User("testuser", "testuser@gmail.com", isAdmin = true))
    } else {
      println("user with userId testuser already exists")
    }
    val authStatus = UserAuthorization.authorize("testuser")
    println(authStatus)
  }

}
