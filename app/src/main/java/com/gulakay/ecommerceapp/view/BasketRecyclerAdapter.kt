package com.gulakay.ecommerceapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gulakay.ecommerceapp.R
import com.gulakay.ecommerceapp.model.Product
import kotlinx.android.synthetic.main.basket_recycler_row.view.*

class BasketRecyclerAdapter (val basketList : List<Product>) : RecyclerView.Adapter<BasketRecyclerAdapter.BasketViewHolder>() {

    class BasketViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.basket_recycler_row,parent,false)
        return BasketViewHolder(view)
    }

    override fun onBindViewHolder(holder: BasketViewHolder, position: Int) {
        val basketImageView = holder.itemView.findViewById<ImageView>(R.id.basketImageView)
        val basketProductNameText = holder.itemView.findViewById<TextView>(R.id.basketProductNameText)
        val basketProductPriceText = holder.itemView.findViewById<TextView>(R.id.basketProductPriceText)
        val basketProductCountText = holder.itemView.findViewById<TextView>(R.id.basketProductCountText)



        basketProductNameText.text= basketList.get(position).name
        basketProductPriceText.text = "Fiyat: ${basketList.get(position).price}"
        basketProductCountText.text ="Adet : ${basketList.get(position).count}"
        Glide.with(holder.itemView.context).load(basketList.get(position).url).into(holder.itemView.basketImageView)

    }

    override fun getItemCount(): Int {
        return basketList.size
    }
}