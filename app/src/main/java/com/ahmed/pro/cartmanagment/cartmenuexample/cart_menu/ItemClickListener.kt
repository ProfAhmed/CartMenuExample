package com.ahmed.pro.cartmanagment.cartmenuexample.cart_menu

import com.ahmed.pro.cartmanagment.cartmenuexample.ui_model.ItemModel

interface ItemClickListener {
    fun onClickDeleteItem(item: ItemModel)
    fun onClickAddNewItem()
    fun onClickClearAll()
}