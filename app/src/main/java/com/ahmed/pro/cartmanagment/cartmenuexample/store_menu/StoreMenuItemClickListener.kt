package com.ahmed.pro.cartmanagment.cartmenuexample.store_menu

import com.ahmed.pro.cartmanagment.cartmenuexample.ui_model.ItemModel

interface StoreMenuItemClickListener {

    fun onClickIncreaseItem(itemModel: ItemModel)

    fun onClickDecreaseItem(itemModel: ItemModel)

    fun onClickCheckout()

}