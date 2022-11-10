package pl.edu.uj.android

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.gson.*
import io.ktor.features.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import pl.edu.uj.android.DataBases.CategoriesDataBase
import pl.edu.uj.android.DataBases.ProductsDataBase
import pl.edu.uj.android.routes.productsRoutes
import pl.edu.uj.android.routes.categoryRoutes

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
fun Application.module() {
    //Database.connect("jdbc:h2:mem:test", driver = "org.h2.Driver", user = "root", password = "")
    Database.connect("jdbc:sqlite:/data.db", "org.sqlite.JDBC")
    transaction { SchemaUtils.create(ProductsDataBase, CategoriesDataBase) }
    productsRoutes()
    categoryRoutes()

    routing {

        get("/") {
            call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
        }

        get("/json/gson") {
            call.respond(mapOf("hello" to "world"))
        }
    }
}

