package com.shashank.implicits.resolution

import spray.json.{JsNumber, JsObject, JsString}


class Animal(val animalType:String)

class Dog(val doesBark:Boolean) extends Animal("dog")

object Animal {
  implicit def toStr(dog:Animal):String = s"Animal of type ${dog.animalType}"
  implicit def toStr(dog:Dog):String = s"Animal of type dog and it barks ${dog.doesBark}"
}


object CompanionObjectOfType {

  def main(args: Array[String]): Unit = {
    val animal:Animal = new Dog(true)
    val animalString:String = animal
    println(animalString)

    val dog:Dog = new Dog(true)
    val dogString:String = dog
    println(dogString)
  }

}
