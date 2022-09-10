package com.ahmed.pro.cartmanagment.cartmenuexample.domain_layer

import com.ahmed.pro.cartmanagment.cartmenuexample.utils.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

//get dummy data from repository
class GetDummyDataUseCase @Inject constructor(private val storeMenuRepository: StoreMenuRepository) {
    operator fun invoke() = flow {
        emit(Resource.loading())
        kotlinx.coroutines.delay(3000) // simulate fetch data from back end
        emit(storeMenuRepository.getDummyData())
    }
}