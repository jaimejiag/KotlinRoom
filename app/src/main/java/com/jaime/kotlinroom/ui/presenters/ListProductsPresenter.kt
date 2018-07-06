package com.jaime.kotlinroom.ui.presenters

import com.jaime.kotlinroom.data.db.models.Product
import com.jaime.kotlinroom.ui.contracts.ListProductsContract
import com.jaime.kotlinroom.ui.interactors.ListProductInteractor

class ListProductsPresenter : ListProductsContract.Presenter, ListProductsContract.Interactor.ListProductListener {
    private var mView: ListProductsContract.View? = null

    private var mInteractor: ListProductsContract.Interactor? = null
    constructor(mView: ListProductsContract.View?) {
        this.mView = mView
        this.mInteractor = ListProductInteractor(this);
    }


    override fun requestToLoadAllProducts() {
        mInteractor!!.loadAllProducts()
    }


    override fun onProductsLoaded(productsList: List<Product>) {
        mView!!.showAllProducts(productsList)
    }


    override fun onDestroy() {
        mView = null
        mInteractor!!.onDestroy()
    }
}