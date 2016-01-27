package models

case class Cat(id: Option[Long], name: String, color: String, activate: Boolean)
//case class Cat(name: String, color: String)

case class Dog(name: String, color: String)