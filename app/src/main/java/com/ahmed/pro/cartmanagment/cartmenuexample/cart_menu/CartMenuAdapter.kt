package com.ahmed.pro.cartmanagment.cartmenuexample.cart_menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ahmed.pro.cartmanagment.cartmenuexample.R
import com.ahmed.pro.cartmanagment.cartmenuexample.databinding.ItemCartMenuBinding
import com.ahmed.pro.cartmanagment.cartmenuexample.ui_model.ItemModel

class CartMenuAdapter(
    private val items: MutableList<ItemModel>?,
    private val itemClickListener: ItemClickListener
) :
    RecyclerView.Adapter<CartMenuAdapter.VH>() {

    inner class VH(val item: ItemCartMenuBinding) : RecyclerView.ViewHolder(item.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_cart_menu,
            parent,
            false
        )
    )


    override fun onBindViewHolder(holder: VH, position: Int) {
        val itemModel = items?.get(position)
        holder.item.apply {
            this.item = itemModel
            this.listener = itemClickListener
        }
    }

    override fun getItemCount() = items?.size ?: 0
}