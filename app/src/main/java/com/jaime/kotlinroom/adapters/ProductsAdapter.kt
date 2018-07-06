package com.jaime.kotlinroom.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.jaime.kotlinroom.R
import com.jaime.kotlinroom.data.db.models.Product


class ProductsAdapter() : RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {
    private var mProductsList = mutableListOf<Product>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_product, parent, false)
        val holder = ProductViewHolder(view)

        return holder
    }


    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.txvName.setText(mProductsList!!.get(position).name)
        holder.txvDescription.setText(mProductsList!!.get(position).description)
        holder.txvPrice.setText(mProductsList!!.get(position).price.toString())
        holder.txvCategory.setText(mProductsList!!.get(position).category.toString())
    }


    override fun getItemCount() = mProductsList!!.size


    fun addAll(productList: List<Product>) {
        mProductsList.clear()
        mProductsList.addAll(productList)
        notifyDataSetChanged()
    }


    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txvName: TextView = itemView.findViewById(R.id.txv_name)
        val txvDescription: TextView = itemView.findViewById(R.id.txv_description)
        val txvPrice: TextView = itemView.findViewById(R.id.txv_price)
        val txvCategory: TextView = itemView.findViewById(R.id.txv_category)
    }
}