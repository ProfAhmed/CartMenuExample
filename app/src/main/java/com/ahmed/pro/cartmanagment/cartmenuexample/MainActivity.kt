package com.ahmed.pro.cartmanagment.cartmenuexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ahmed.pro.cartmanagment.cartmenuexample.click_listener.ItemClickListener
import com.ahmed.pro.cartmanagment.cartmenuexample.databinding.ActivityMainBinding
import com.ahmed.pro.cartmanagment.cartmenuexample.ui_model.ItemModel
import com.ahmed.pro.cartmanagment.cartmenuexample.ui_model.listName
import com.ahmed.pro.cartmanagment.cartmenuexample.ui_model.listPrices
import com.ahmed.pro.cartmanagment.cartmenuexample.utils.calculateTotal

class MainActivity : AppCompatActivity(), ItemClickListener {
    private lateinit var binding: ActivityMainBinding
    private val dummyList = mutableListOf(ItemModel(), ItemModel(), ItemModel())
    private var menuAdapter: CartMenuAdapter? = null
    private var total = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initMenuAdapter()
        initTotal()
        bindViews()
    }

    private fun initTotal() {
        total = calculateTotal(dummyList)
    }

    private fun bindViews() {
        binding.total = total.toString()
        binding.listener = this
    }

    private fun initMenuAdapter() {
        menuAdapter = CartMenuAdapter(dummyList, this)
        binding.rvItems.adapter = menuAdapter
    }

    override fun onClickDeleteItem(item: ItemModel) {
        dummyList.remove(item)
        total -= item.priceDouble()
        bindViews()
        initMenuAdapter()
    }

    override fun onClickAddNewItem() {
        val newItem = ItemModel(listName[(0..2).random()], listPrices[(0..2).random()])
        dummyList.add(newItem)
        total += newItem.priceDouble()
        bindViews()
        initMenuAdapter()
    }

    override fun onClickClearAll() {
        dummyList.clear()
        total = 0.0
        bindViews()
        initMenuAdapter()
    }
}