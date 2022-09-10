package com.ahmed.pro.cartmanagment.cartmenuexample.cart_menu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ahmed.pro.cartmanagment.cartmenuexample.databinding.ActivityCartMenuBinding
import com.ahmed.pro.cartmanagment.cartmenuexample.ui_model.ItemModel
import com.ahmed.pro.cartmanagment.cartmenuexample.ui_model.listName
import com.ahmed.pro.cartmanagment.cartmenuexample.ui_model.listPrices
import com.ahmed.pro.cartmanagment.cartmenuexample.utils.calculateTotal

class CartMenuActivity : AppCompatActivity(), ItemClickListener {
    private lateinit var binding: ActivityCartMenuBinding
    private var menuAdapter: CartMenuAdapter? = null
    private var selectedItems = mutableListOf<ItemModel>()
    private var totalPassed = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartMenuBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        getPassedData()
        initMenuAdapter()
        bindViews()
    }

    private fun getPassedData() {
        totalPassed = intent.getDoubleExtra("total", 0.0)
        selectedItems = intent.getSerializableExtra("items") as MutableList<ItemModel>
    }

    private fun bindViews() {
        binding.total = totalPassed.toString()
        binding.listener = this
    }

    private fun initMenuAdapter() {
        menuAdapter = CartMenuAdapter(selectedItems, this)
        binding.rvItems.adapter = menuAdapter
    }

    override fun onClickDeleteItem(item: ItemModel) {
        selectedItems.remove(item)
        totalPassed -= (item.priceDouble() * item.counter())
        bindViews()
        initMenuAdapter()
    }

    override fun onClickAddNewItem() {
        onBackPressed()
    }

    override fun onClickClearAll() {
        selectedItems.clear()
        totalPassed = 0.0
        bindViews()
        initMenuAdapter()
    }
}