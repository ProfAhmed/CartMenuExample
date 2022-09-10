package com.ahmed.pro.cartmanagment.cartmenuexample.store_menu

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.ahmed.pro.cartmanagment.cartmenuexample.databinding.ActivityStoreMenuBinding
import com.ahmed.pro.cartmanagment.cartmenuexample.ui_model.ItemModel
import com.ahmed.pro.cartmanagment.cartmenuexample.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class StoreMenuActivity : AppCompatActivity(), StoreMenuItemClickListener {
    private val storeMenuViewModel by viewModels<StoreMenuViewModel>()
    private lateinit var binding: ActivityStoreMenuBinding
    private var storeMenuAdapter: StoreMenuAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoreMenuBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        getDummyData()
        collectTotal()
    }

    private fun collectTotal() {
        lifecycleScope.launch {
            storeMenuViewModel.total.collectLatest {
                binding.total = it.toString()
            }
        }
    }

    private fun getDummyData() = lifecycleScope.launch {
        storeMenuViewModel.dummyData.collectLatest {
            binding.progress.isVisible = false
            when (it.status) {
                Status.LOADING -> binding.progress.isVisible = true
                Status.SUCCESS -> initMenuAdapter(it.data)
                Status.EMPTY -> {}
                else -> {
                    Toast.makeText(
                        this@StoreMenuActivity,
                        "Unknown error Occurred",
                        Toast.LENGTH_LONG
                    ).show()
                }

            }
        }
    }

    private fun initMenuAdapter(items: List<ItemModel>?) {
        storeMenuAdapter = StoreMenuAdapter(this, items, this)
        binding.rvItems.adapter = storeMenuAdapter
    }

    override fun onClickIncreaseItem(itemModel: ItemModel) {
        val counter = storeMenuViewModel.incrementItem(itemModel)
        storeMenuAdapter?.updateCounter(counter)
    }

    override fun onClickDecreaseItem(itemModel: ItemModel) {
        val counter = storeMenuViewModel.decreaseItem(itemModel)
        storeMenuAdapter?.updateCounter(counter)
    }

    override fun onClickCheckout() {
    }
}