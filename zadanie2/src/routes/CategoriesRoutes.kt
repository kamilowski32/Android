package pl.edu.uj.android.routes

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import pl.edu.uj.android.models.Category
import pl.edu.uj.android.controllers.CategoriesController

fun Application.categoryRoutes()
{
    routing { CategoryRoutes() }
}

fun Route.CategoryRoutes()
{
    route("/category")
    {
        get{
            call.respond(CategoriesController().getAllCategories())
        }
        get("/get/{name}"){
            val string = call.parameters["name"]
            call.respond(CategoriesController().getByName(string.toString()))
        }
        post{
            val category = call.receive<Category>()
            CategoriesController().add(category)
            call.respondText("Category added", status = HttpStatusCode.OK)
        }
        delete("{Name}")
        {
            CategoriesController().delete(call.parameters["Name"].toString())
            call.respondText("Category removed", status = HttpStatusCode.Gone)
        }
    }
}