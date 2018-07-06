package com.jaime.kotlinroom.ui.contracts

import com.jaime.kotlinroom.data.db.models.Product

interface ListProductsContract {

    interface View {
        fun showAllProducts(productsList: List<Product>)
    }


    interface Presenter {
        fun requestToLoadAllProducts()

        fun onDestroy()
    }


    interface Interactor {
        fun loadAllProducts()

        fun onDestroy()

        interface ListProductListener {
            fun onProductsLoaded(productsList: List<Product>)
        }
    }
}