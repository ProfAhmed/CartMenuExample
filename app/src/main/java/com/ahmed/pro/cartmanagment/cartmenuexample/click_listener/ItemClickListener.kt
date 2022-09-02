package com.ahmed.pro.cartmanagment.cartmenuexample.click_listener

import com.ahmed.pro.cartmanagment.cartmenuexample.ui_model.ItemModel

interface ItemClickListener {
    fun onClickDeleteItem(item: ItemModel)
    fun onClickAddNewItem()
    fun onClickClearAll()
}