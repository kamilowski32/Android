package pl.edu.uj.android.DataBases


import io.ktor.routing.*
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object CategoriesDataBase:Table() {
    var id : Column<Int> = integer("id").autoIncrement()
    var name : Column<String> = varchar("name", 50)
    var supplier : Column<String> = varchar("supplier", 5)
    var warehouse : Column<String> = varchar("warehouse", 5)
    override val primaryKey = PrimaryKey(id)
}