package com.shashank.implicits.dependency_injection.implicitway

/**
  * Created by shashank on 20/07/2017.
  */
object ComponentRegistry {

  implicit val userRepository: UserRepository = new InMemoryUserRepository
  val userService = new UserService


  def main(args: Array[String]) {
    userService.create("testuser", "abc123", "testuser@gmail.com")
    println(userService.authenticate("testuser", "abc123"))
    println(userService.authenticate("testuser", "ab123"))
  }

}
