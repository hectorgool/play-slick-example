package controllers


import dao.CatDAO
import dao.DogDAO
import javax.inject.Inject
import models.Cat
import play.api.data.Form
import play.api.data.Forms.mapping
import play.api.data.Forms.text
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.mvc.Action
import play.api.mvc.Controller
import models.Dog
import play.api.libs.json._


class Application @Inject() (catDao: CatDAO, dogDao: DogDAO) extends Controller {

	def index = Action.async {
		catDao.all().zip(dogDao.all()).map {
			case (cats, dogs) => 
				Ok(views.html.index(cats, dogs)) 
		}
	}

	def cats = Action.async {

		catDao.all().map {
			case (cats) => 
				Ok(views.html.cats(cats)) 
		}

	}

	def jsonCats = Action.async {

		catDao.all().map{ s =>
			Ok(
				JsArray(s.map(t =>Json.obj("sender" -> t.name, "content" -> t.color)))
			)
		}

	}

	def jsonCatsSQL = Action.async {

		catDao.sqlQuery().map{ s =>
			Ok(
				JsArray(s.map(t =>Json.obj("sender" -> t.name, "content" -> t.color)))
			)
		}

	}

	val catForm = Form(
		mapping(
		  "name" -> text(),
		  "color" -> text()
		)(Cat.apply)(Cat.unapply)
	)

	val dogForm = Form(
		mapping(
		  "name" -> text(),
		  "color" -> text()
		)(Dog.apply)(Dog.unapply)
	)

	def insertCat = Action.async { implicit request =>
		val cat: Cat = catForm.bindFromRequest.get
		catDao.insert(cat).map(_ => Redirect(routes.Application.index))
	}

	def insertDog = Action.async { implicit request =>
		val dog: Dog = dogForm.bindFromRequest.get
		dogDao.insert(dog).map(_ => Redirect(routes.Application.index))
	}

}
