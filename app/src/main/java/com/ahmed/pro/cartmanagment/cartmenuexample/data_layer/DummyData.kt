package com.ahmed.pro.cartmanagment.cartmenuexample.data_layer

import com.ahmed.pro.cartmanagment.cartmenuexample.ui_model.ItemModel
import com.ahmed.pro.cartmanagment.cartmenuexample.utils.Resource
import javax.inject.Inject

// dummy data
class DummyData @Inject constructor() {
    private val dummyList =
        mutableListOf(ItemModel(), ItemModel(), ItemModel(), ItemModel(), ItemModel(), ItemModel())

    fun dummyList() = Resource.success(dummyList) // invoke success data

}