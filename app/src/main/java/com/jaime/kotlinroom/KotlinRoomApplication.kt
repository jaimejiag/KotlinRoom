package com.jaime.kotlinroom

import android.app.Application
import com.jaime.kotlinroom.data.db.dao.CategoryDAO
import com.jaime.kotlinroom.data.db.models.KotlinRoomDatabase
import com.jaime.kotlinroom.data.db.dao.ProductDAO
import com.jaime.kotlinroom.data.db.models.Product

class KotlinRoomApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        mDatabase = KotlinRoomDatabase.getInstance(this)

        if (mDatabase!!.productDAO.getAll().isEmpty())
            mockDatabase()
    }


    companion object {
        private var mDatabase: KotlinRoomDatabase? = null
        private var mContext = KotlinRoomApplication()

        fun getContext(): KotlinRoomApplication {
            return mContext
        }
    }


    fun getProductDAO(): ProductDAO {
        return mDatabase!!.productDAO
    }


    fun getCategoryDAO(): CategoryDAO {
        return mDatabase!!.categoryDAO
    }


    private fun mockDatabase() {
        var product = Product("iPhone 7", "Móvil smartphone de Apple", 699.99, 1)
        mDatabase!!.productDAO.insert(product)

        product = Product("Escritorio X", "Escritorio negro de tamaño medio", 55.50, 2)
        mDatabase!!.productDAO.insert(product)
    }
}