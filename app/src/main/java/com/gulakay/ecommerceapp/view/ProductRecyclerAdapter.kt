package com.gulakay.ecommerceapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gulakay.ecommerceapp.R
import com.gulakay.ecommerceapp.model.Product
import kotlinx.android.synthetic.main.recycler_row.view.*

class ProductRecyclerAdapter (val productList: List<Product>, private val listener: Listener): RecyclerView.Adapter<ProductRecyclerAdapter.ProductHolder>() {

    class ProductHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row,parent,false)
        return ProductHolder(view)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.itemView.productName.text = productList.get(position).name
        holder.itemView.productPrice.text="${productList.get(position).price} ₺"
        Glide.with(holder.itemView.context).load(productList.get(position).url).into(holder.itemView.productImage)
        holder.itemView.addBasketButton.setOnClickListener {
            Toast.makeText(it.context,"${productList.get(position).name} Sepete Eklendi" ,Toast.LENGTH_LONG).show()
            listener.onItemClick(productList.get(position))
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }
    interface Listener{
        fun onItemClick(product: Product)
    }
}