package com.jaime.kotlinroom.data.db.models

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.jaime.kotlinroom.KotlinRoomApplication
import com.jaime.kotlinroom.data.db.KotlinRoomContract
import com.jaime.kotlinroom.data.db.dao.CategoryDAO
import com.jaime.kotlinroom.data.db.dao.ProductDAO
import com.jaime.kotlinroom.data.repositories.ProductsRepository

@Database(entities = arrayOf(Product::class, Category::class), version = KotlinRoomContract.DATABASE_VERSION)
abstract class KotlinRoomDatabase() : RoomDatabase() {
    abstract val productDAO : ProductDAO
    abstract val categoryDAO : CategoryDAO


    companion object {
        private var mInstance: KotlinRoomDatabase? = null

        fun getInstance(context: Context): KotlinRoomDatabase? {
            if (mInstance == null) {
                synchronized(KotlinRoomDatabase::class) {
                    mInstance = Room.databaseBuilder(context.applicationContext, KotlinRoomDatabase::class.java,
                            KotlinRoomContract.DATABASE_NAME)
                            .allowMainThreadQueries()
                            .build()
                }
            }

            return mInstance
        }
    }
}