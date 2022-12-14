package com.ahmed.pro.cartmanagment.cartmenuexample.store_menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.ahmed.pro.cartmanagment.cartmenuexample.R
import com.ahmed.pro.cartmanagment.cartmenuexample.databinding.ItemStoreMenuBinding
import com.ahmed.pro.cartmanagment.cartmenuexample.ui_model.ItemModel

class StoreMenuAdapter(
    private val context: LifecycleOwner,
    private val items: List<ItemModel>?,
    private val itemClickListener: StoreMenuItemClickListener
) :
    RecyclerView.Adapter<StoreMenuAdapter.VH>() {

    private val counterMutableLiveData = MutableLiveData("0")

    inner class VH(val item: ItemStoreMenuBinding) : RecyclerView.ViewHolder(item.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_store_menu,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: StoreMenuAdapter.VH, position: Int) {
        val itemModel = items?.get(position)
        holder.item.apply {
            this.item = itemModel
            this.listener = itemClickListener
            counterMutableLiveData.observe(context) {
                this.item = itemModel
            }
        }
    }

    fun updateCounter(counter: Int) {
        counterMutableLiveData.value = counter.toString()
    }

    override fun getItemCount() = items?.size ?: 0

}