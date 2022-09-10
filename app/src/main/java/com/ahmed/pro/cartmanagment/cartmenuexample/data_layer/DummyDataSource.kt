package com.ahmed.pro.cartmanagment.cartmenuexample.data_layer

import javax.inject.Inject
import javax.inject.Singleton

//dummy data source
@Singleton
class DummyDataSource @Inject constructor(private val dummyData: DummyData) {

    fun getDummyList() = dummyData.dummyList()
}