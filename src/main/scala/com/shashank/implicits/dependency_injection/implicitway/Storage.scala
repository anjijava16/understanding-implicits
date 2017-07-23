package com.shashank.implicits.dependency_injection.implicitway

import com.mongodb.MongoClient
import com.mongodb.casbah.Imports._
import com.mongodb.util.JSON
import scala.util.Try

/**
  * Created by shashank on 23/07/2017.
  */

trait UserRepository { // Interface exposed to the user
  def get(username: String): Option[User]
  def put(user:User):Option[User]
}

case class User(username: String, email:String, isAdmin:Boolean)

class MongoDbUserRepository extends UserRepository {

  val host = "localhost"
  val port = 27017
  val database = "meetup_demo"
  val collectionName = "user"

  override def get(username: String): Option[User] = {
    val client = new MongoClient(host, port)
    val collection = client.getDB(database).getCollection(collectionName)
    Try {
      val dbObject = collection.findOne(JSON.parse(s"""{"username":"${username}"}""").asInstanceOf[DBObject])
      client.close()
      Some(User(dbObject.get("username").toString, dbObject.get("email").toString, dbObject.get("isAdmin").toString.toBoolean))
    }.getOrElse{
      client.close()
      None
    }
  }

  override def put(user: User): Option[User] = {
    val client = new MongoClient(host, port)
    val collection = client.getDB(database).getCollection(collectionName)
    val dbObject = JSON.parse(s"""{"username":"${user.username}", "email":"${user.email}", "isAdmin":${user.isAdmin}}""").asInstanceOf[DBObject]
    collection.insert(dbObject)
    client.close()
    get(user.username)
  }
}

class InMemoryUserRepository extends UserRepository {

  val users = scala.collection.concurrent.TrieMap[String, User]()

  override def get(username: String): Option[User] = {
    users.get(username)
  }

  override def put(user: User): Option[User] = {
    users += user.username -> user
    get(user.username)
  }
}
