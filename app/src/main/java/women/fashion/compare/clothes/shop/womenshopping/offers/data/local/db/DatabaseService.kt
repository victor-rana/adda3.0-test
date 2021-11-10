package women.fashion.compare.clothes.shop.womenshopping.offers.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import javax.inject.Singleton

@Singleton
@Database(
    entities = [
        women.fashion.compare.clothes.shop.womenshopping.offers.data.local.db.entity.DummyEntity::class
    ],
    exportSchema = false,
    version = 1
)
abstract class DatabaseService : RoomDatabase() {

    abstract fun dummyDao(): women.fashion.compare.clothes.shop.womenshopping.offers.data.local.db.dao.DummyDao
}