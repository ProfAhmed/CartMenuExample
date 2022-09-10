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

    private val _total = MutableStateFlow(0.0)
    var total: StateFlow<Double> = _total
    private val _dummyData = MutableStateFlow<Resource<List<ItemModel>>>(Resource.empty())
    val dummyData: StateFlow<Resource<List<ItemModel>>> = _dummyData
    private val _selectedItems = mutableListOf<ItemModel>()
    private fun getDummyData() {
        viewModelScope.launch {
            getDummyDataUseCase.invoke().collectLatest {
                _dummyData.value = it
            }
        }
    }

    fun incrementItem(itemModel: ItemModel): Int {
        _total.value += itemModel.priceDouble()
        if (_selectedItems.contains(itemModel).not()) {
            _selectedItems.add(itemModel)
            itemModel.incrementCounter()
        } else itemModel.incrementCounter()

        return itemModel.counter()
    }

    fun decreaseItem(itemModel: ItemModel): Int {
        if (_selectedItems.contains(itemModel).not()) return 0

        _total.value -= itemModel.priceDouble()

        if (_selectedItems.contains(itemModel) && itemModel.counter() == 1) {
            _selectedItems.remove(itemModel)
            itemModel.decrementCounter()
            return 0
        }

        itemModel.decrementCounter()
        return itemModel.counter()
    }
}