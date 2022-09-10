package com.ahmed.pro.cartmanagment.cartmenuexample.data_layer

import com.ahmed.pro.cartmanagment.cartmenuexample.domain_layer.StoreMenuRepository
import com.ahmed.pro.cartmanagment.cartmenuexample.ui_model.ItemModel
import com.ahmed.pro.cartmanagment.cartmenuexample.utils.Resource
import javax.inject.Inject

class StoreMenuRepositoryImp @Inject constructor(private val dataSource: DummyDataSource) :
    StoreMenuRepository {
    override suspend fun getDummyData(): Resource<List<ItemModel>> {
        return dataSource.getDummyList()
    }
}