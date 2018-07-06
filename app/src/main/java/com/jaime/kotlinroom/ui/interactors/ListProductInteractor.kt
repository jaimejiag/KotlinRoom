package com.jaime.kotlinroom.ui.interactors

import com.jaime.kotlinroom.data.repositories.ProductsRepository
import com.jaime.kotlinroom.ui.contracts.ListProductsContract

class ListProductInteractor : ListProductsContract.Interactor {
    private var mListener: ListProductsContract.Interactor.ListProductListener? = null


    constructor(listener: ListProductsContract.Interactor.ListProductListener) {
        mListener = listener
    }


    override fun loadAllProducts() {
        mListener!!.onProductsLoaded(ProductsRepository.getInstance()!!.getAllProducts())
    }


    override fun onDestroy() {
        mListener = null
    }
}