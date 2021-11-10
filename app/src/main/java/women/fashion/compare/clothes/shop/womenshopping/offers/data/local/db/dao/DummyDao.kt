package women.fashion.compare.clothes.shop.womenshopping.offers.data.local.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface DummyDao {

    @Query("SELECT * FROM dummy_entity")
    fun getAll(): List<women.fashion.compare.clothes.shop.womenshopping.offers.data.local.db.entity.DummyEntity>

    @Insert
    fun insert(entity: women.fashion.compare.clothes.shop.womenshopping.offers.data.local.db.entity.DummyEntity)

    @Delete
    fun delete(entity: women.fashion.compare.clothes.shop.womenshopping.offers.data.local.db.entity.DummyEntity)
}