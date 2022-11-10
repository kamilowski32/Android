package pl.edu.uj.android.controllers

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction
import pl.edu.uj.android.DataBases.CategoriesDataBase
import pl.edu.uj.android.models.Category

class CategoriesController
{
    fun add(category : Category)
    {
        transaction {
            CategoriesDataBase.insert{
                it[name] = category.name
                it[supplier] = category.supplier
                it[warehouse] = category.warehouse
            }
        }
    }
    fun getAllCategories():ArrayList<Category>
    {
        val categories : ArrayList<Category> = ArrayList()
        transaction {
            CategoriesDataBase.selectAll().map()
            {
                categories.add(
                    Category(
                        it[CategoriesDataBase.id],
                        it[CategoriesDataBase.name],
                        it[CategoriesDataBase.supplier],
                        it[CategoriesDataBase.warehouse]
                    )
                )
            }
        }
        return categories
    }
    fun getByName(name:String):ArrayList<Category>
    {
        val categories : ArrayList<Category> = ArrayList()
        transaction {
            CategoriesDataBase.select(CategoriesDataBase.name eq name).map()
            {
                categories.add(
                    Category(
                        it[CategoriesDataBase.id],
                        it[CategoriesDataBase.name],
                        it[CategoriesDataBase.supplier],
                        it[CategoriesDataBase.warehouse]
                    )
                )
            }
        }
        return categories
    }
    fun delete(name:String)
    {
        transaction { CategoriesDataBase.deleteWhere { CategoriesDataBase.name eq name } }
    }
}