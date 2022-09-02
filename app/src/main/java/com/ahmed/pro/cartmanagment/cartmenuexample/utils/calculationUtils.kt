package com.ahmed.pro.cartmanagment.cartmenuexample.utils

import com.ahmed.pro.cartmanagment.cartmenuexample.ui_model.ItemModel


fun calculateTotal(list: MutableList<ItemModel>): Double {
    var total = 0.0
    list.forEach {
        total += it.priceDouble()
    }
    return total
}