package pl.edu.uj.android.models

import org.jetbrains.exposed.sql.*

object Products : Table() {
    val id = integer("id").autoIncrement() // Column<Int>
    val title = varchar("title", 50) // Column<String>
    val category = integer("category").references(Categories.id)
    val price = integer("price")

    override val primaryKey = PrimaryKey(id, name = "PK_Products_ID")
}

data class Product(val id: Int, val title: String, val category: Int, val price: Int)
