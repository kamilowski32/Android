package pl.edu.uj.android.models

import org.jetbrains.exposed.sql.*
import com.rnett.exposedgson.*

object Categories : Table() {
    val id = integer("id").autoIncrement() // Column<Int>
    val name = varchar("title", 50) // Column<String>
    val supplier = varchar("supplier",5)
    val warehouse = varchar("warehouse",5)

    override val primaryKey = PrimaryKey(id, name = "PK_Categories_ID")
}

data class Category(val id: Int, val name: String, val supplier: String, val warehouse: String)
