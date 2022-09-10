package com.ahmed.pro.cartmanagment.cartmenuexample.store_menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmed.pro.cartmanagment.cartmenuexample.domain_layer.GetDummyDataUseCase
import com.ahmed.pro.cartmanagment.cartmenuexample.ui_model.ItemModel
import com.ahmed.pro.cartmanagment.cartmenuexample.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StoreMenuViewModel @Inject constructor(private val getDummyDataUseCase: GetDummyDataUseCase) :
    ViewModel() {

    init {
        getDummyData()
    }

    private val _dummyData = MutableStateFlow<Resource<List<ItemModel>>>(Resource.empty())
    val dummyData: StateFlow<Resource<List<ItemModel>>> = _dummyData

    private fun getDummyData() {
        viewModelScope.launch {
            getDummyDataUseCase.invoke().collectLatest {
                _dummyData.value = it
            }
        }
    }
}