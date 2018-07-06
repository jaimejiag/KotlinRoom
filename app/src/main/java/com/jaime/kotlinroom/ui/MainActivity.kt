package com.jaime.kotlinroom.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.jaime.kotlinroom.R
import com.jaime.kotlinroom.adapters.ProductsAdapter
import com.jaime.kotlinroom.data.db.models.Product
import com.jaime.kotlinroom.ui.contracts.ListProductsContract
import com.jaime.kotlinroom.ui.presenters.ListProductsPresenter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), ListProductsContract.View {
    private val mPresenter = ListProductsPresenter(this)
    private val mAdapter = ProductsAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_products.setHasFixedSize(true)
        rv_products.layoutManager = LinearLayoutManager(this)
        rv_products.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        rv_products.adapter = mAdapter

        mPresenter.requestToLoadAllProducts()
    }


    override fun showAllProducts(productsList: List<Product>) {
        mAdapter.addAll(productsList)
    }
}
