package models

case class Cat(id: Option[Long] = None, name: String, color: String, activate: Boolean)
//case class Cat(name: String, color: String)

case class Dog(name: String, color: String)

case class Product(sku: String, title: String)

object JsonFormats {

  import play.api.libs.json.Json
  // Generates Writes and Reads for Feed and User thanks to Json Macros
  implicit val itemProduct = Json.format[Product]

}

