package com.shashank.implicits.dependency_injection.implicitway

/**
  * Created by shashank on 20/07/2017.
  */
object ComponentRegistry extends UserServiceComponent with UserRepositoryComponent{

  val userService: UserService = new UserServiceImpl
  implicit val userRepository: UserRepository = new InMemoryUserRepositoryComponent

  def main(args: Array[String]) {
    userService.create("testuser", "abc123", "testuser@gmail.com")
    println(userService.authenticate("testuser", "abc123"))
    println(userService.authenticate("testuser", "ab123"))
  }

}
