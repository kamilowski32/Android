package pl.edu.uj.android.controllers

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction
import pl.edu.uj.android.DataBases.ProductsDataBase
import pl.edu.uj.android.models.Product

class ProductController
{
    fun add(product : Product)
    {
        transaction {
            ProductsDataBase.insert{
                it[title] = product.title
                it[price] = product.price
                it[category] = product.category
            }
        }
    }
    fun getAllProducts():ArrayList<Product>
    {
        val products : ArrayList<Product> = ArrayList()
        transaction {
            ProductsDataBase.selectAll().map()
            {
                products.add(
                    Product(
                        it[ProductsDataBase.id],
                        it[ProductsDataBase.title],
                        it[ProductsDataBase.price],
                        it[ProductsDataBase.category]
                    )
                )
            }
        }
        return products
    }
    fun getByTitle(title:String):ArrayList<Product>
    {
        val products : ArrayList<Product> = ArrayList()
        transaction {
            ProductsDataBase.select(ProductsDataBase.title eq title).map()
            {
                products.add(
                    Product(
                        it[ProductsDataBase.id],
                        it[ProductsDataBase.title],
                        it[ProductsDataBase.price],
                        it[ProductsDataBase.category]
                    )
                )
            }
        }
        return products
    }
    fun delete(title:String)
    {
        transaction { ProductsDataBase.deleteWhere { ProductsDataBase.title eq title } }
    }
}