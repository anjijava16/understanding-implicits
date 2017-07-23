package com.shashank.implicits.dependency_injection.implicitway

import com.mongodb.MongoClient
import com.mongodb.casbah.Imports._
import com.mongodb.util.JSON
import scala.util.Try

case class User(username: String, password:String, email:String)

trait UserRepository {
  def get(username: String): Option[User]
  def delete(username: String): Boolean
  def create(user: User): Option[User]
}


trait UserRepositoryComponent {
  val userRepository:UserRepository

  class InMemoryUserRepositoryComponent extends UserRepository{
    private val users = scala.collection.concurrent.TrieMap[String, User]()

    def get(username: String): Option[User] =
      users.get(username)

    def delete(username: String): Boolean =
      users.remove(username).isDefined

    def create(user: User): Option[User] =
      users.put(user.username, user)
  }
}