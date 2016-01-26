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

	private val Cats = TableQuery[CatsTable]

	def all(): Future[Seq[Cat]] = db.run(Cats.result)

	def insert(cat: Cat): Future[Unit] = db.run(Cats += cat).map { _ => () }
	
   	implicit val GetCat = GetResult(r =>
    	Cat(
    		name     = r.<<,
            color    = r.<<,
            activate = r.<<
		)
    )
   	
	def sqlQuery(): Future[Seq[Cat]] = db.run(
		sql"""select NAME, COLOR, ACTIVATE from CAT """.as[Cat]
	)
	

	private class CatsTable(tag: Tag) extends Table[Cat](tag, "CAT") {

		def name = column[String]("NAME", O.PrimaryKey)
		def color = column[String]("COLOR")
		def activate = column[Boolean]("ACTIVATE")
		def * = (name, color, activate) <> (Cat.tupled, Cat.unapply _)
		//def * = (name, color) <> (Cat.tupled, Cat.unapply _)

	}


}