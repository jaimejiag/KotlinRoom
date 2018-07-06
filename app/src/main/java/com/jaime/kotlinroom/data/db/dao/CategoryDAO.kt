package com.jaime.kotlinroom.data.db.dao

import android.arch.persistence.room.*
import com.jaime.kotlinroom.data.db.models.Category
import com.jaime.kotlinroom.data.db.KotlinRoomContract

@Dao
interface CategoryDAO {

    @Query(KotlinRoomContract.CategoryEntry.SQL_QUERY_ENTRIES)
    fun getAll(): List<Category>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(category: Category)


    @Update
    fun update(category: Category)


    @Delete
    fun delete(category: Category)
}