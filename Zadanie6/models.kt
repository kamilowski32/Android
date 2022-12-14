import io.realm.kotlin.Realm
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

open class Product : RealmObject {
    @PrimaryKey
    var id: Long = 0
    var name: String = ""
    var price: Double = 0.0
    var categoryId: Long = 0
    lateinit var category : Category
}


open class Category :  RealmObject {
    @PrimaryKey
    var id: Long = 0
    var name: String = ""
    var products: RealmList<Product> = realmListOf()
}

open class Cart : RealmObject {
    @PrimaryKey var id: Long = 0
    var products : RealmList<Product> = realmListOf()
    lateinit var user : User
}

open class User : RealmObject
{
    @PrimaryKey var id: Long = 0
    var email: String = ""
    var name: String = ""
    var surname: String = ""
    var password: String = ""
}