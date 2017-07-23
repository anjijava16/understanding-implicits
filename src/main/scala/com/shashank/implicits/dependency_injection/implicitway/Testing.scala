package com.shashank.implicits.dependency_injection.implicitway

import org.scalatest.{Matchers, WordSpec}

/**
  * Created by shashank on 23/07/2017.
  */
trait TestEnvironment extends WordSpec with UserRepositoryComponent with UserServiceComponent with Matchers {

  val userService: UserService = new UserServiceImpl
  implicit val userRepository: UserRepository = new InMemoryUserRepositoryComponent

}


class Testing extends TestEnvironment{

  "should create user" in {
    userService.create("testuser", "test1234", "test123@gmail.com")
    val savedUser = userRepository.get("testuser")
    savedUser.isDefined shouldEqual true
    savedUser.get.username shouldEqual "testuser"
    userService.delete(savedUser.get.username)
  }

  "should authenticate user" in {
    userService.create("testuser", "test1234", "test123@gmail.com")
    userService.authenticate("testuser", "test1234") shouldEqual true
    userService.authenticate("testuser", "test12") shouldEqual false
  }

}
