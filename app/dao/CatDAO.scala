package dao


import scala.concurrent.Future
import javax.inject.Inject
import models.Cat
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import slick.driver.JdbcProfile

import slick.jdbc.GetResult


class CatDAO @Inject()(protected val dbConfigProvider: DatabaseConfigProvider) extends HasDatabaseConfigProvider[JdbcProfile] {

	
	import driver.api._

	val Cats = TableQuery[CatsTable]

	def all(): Future[Seq[Cat]] = 
		db.run(Cats.result)

	def insert(cat: Cat): Future[Unit] =
    	try db.run(Cats += cat).map { _ => () }
    	finally db.close

    def filterQuery(id: Long) =
    	Cats.filter(_.id === id)
	
	def count(filter: String): Future[Int] =
    	try db.run(Cats.filter(_.name.toLowerCase like filter.toLowerCase()).length.result)
    	finally db.close

	def count: Future[Int] =
    	try db.run(Cats.length.result)
    	finally db.close

	def findById(id: Long): Future[Cat] =
    	try db.run(filterQuery(id).result.head)
    	finally db.close

    def update(id: Long, cat: Cat): Future[Int] =
    	try db.run(filterQuery(id).update(cat))
    	finally db.close

	def delete(id: Long): Future[Int] =
    	try db.run(filterQuery(id).delete)
    	finally db.close    	

   	implicit val GetCat = GetResult(r =>
    	Cat(
    		id       = r.<<,
    		name     = r.<<,
            color    = r.<<,
            activate = r.<<
		)
    )
   	
	def sqlQuery(): Future[Seq[Cat]] = db.run(
		sql"""select NAME, COLOR, ACTIVATE from CAT """.as[Cat]
	)
	

	class CatsTable(tag: Tag) extends Table[Cat](tag, "CAT") {

		def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
		def name = column[String]("NAME")
		def color = column[String]("COLOR")
		def activate = column[Boolean]("ACTIVATE")
		def * = (id.?, name, color, activate) <> (Cat.tupled, Cat.unapply _)
		//def * = (name, color) <> (Cat.tupled, Cat.unapply _)

	}


}