package com.jaime.kotlinroom.data.repositories

import com.jaime.kotlinroom.KotlinRoomApplication
import com.jaime.kotlinroom.data.db.models.Product


class ProductsRepository {
    private val mProductDao = KotlinRoomApplication.getContext().getProductDAO()


    companion object {
        private var mInstance: ProductsRepository? = null

        fun getInstance(): ProductsRepository? {
            if (mInstance == null)
                mInstance = ProductsRepository()

            return mInstance
        }
    }


    fun insertProduct(product: Product) {
        mProductDao.insert(product)
    }


    fun getAllProducts(): List<Product> {
        return mProductDao.getAll();
    }
}