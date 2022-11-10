package pl.edu.uj.android.DataBases

import io.ktor.routing.*
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object ProductsDataBase:Table() {
    var id : Column<Int> = integer("id").autoIncrement()
    var title : Column<String> = varchar("title", 50)
    var category : Column<Int> = integer("category").references(CategoriesDataBase.id)
    var price : Column<Int> = integer("price")
    override val primaryKey = PrimaryKey(id)
}