package com.jaime.kotlinroom.data.db.dao

import android.arch.persistence.room.*
import com.jaime.kotlinroom.data.db.KotlinRoomContract
import com.jaime.kotlinroom.data.db.models.Product
import com.jaime.kotlinroom.data.db.models.Category

@Dao
interface ProductDAO {

    @Query("SELECT p.id " + KotlinRoomContract.ProductEntry.COLUMN_ID + ", p.name, p.description, p.price, c.name category FROM product p INNER JOIN category c ON p.category = c.id")
    fun getAll(): List<Product>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(product: Product)


    @Update
    fun update(product: Product)


    @Delete
    fun delete(product: Product)
}