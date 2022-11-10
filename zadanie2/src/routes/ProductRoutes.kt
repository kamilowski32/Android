package pl.edu.uj.android.routes

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import pl.edu.uj.android.models.Product
import pl.edu.uj.android.controllers.ProductController

fun Application.productsRoutes()
{
    routing { ProductRoutes() }
}

fun Route.ProductRoutes()
{
    route("/product")
    {
        get{
            call.respond(ProductController().getAllProducts())
        }
        get("/get/{title}"){
            val string = call.parameters["title"]
            call.respond(ProductController().getByTitle(string.toString()))
        }
        post{
            val product = call.receive<Product>()
            ProductController().add(product)
            call.respondText("Product added", status = HttpStatusCode.OK)
        }
        delete("{title}")
        {
            ProductController().delete(call.parameters["title"].toString())
            call.respondText("Product removed", status = HttpStatusCode.Gone)
        }
    }
}