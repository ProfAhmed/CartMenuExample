package com.ahmed.pro.cartmanagment.cartmenuexample.domain_layer

import com.ahmed.pro.cartmanagment.cartmenuexample.ui_model.ItemModel
import com.ahmed.pro.cartmanagment.cartmenuexample.utils.Resource

interface StoreMenuRepository {
    suspend fun getDummyData(): Resource<List<ItemModel>>
}