package com.ahmed.pro.cartmanagment.cartmenuexample.store_menu

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.ahmed.pro.cartmanagment.cartmenuexample.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class StoreMenuActivity : AppCompatActivity() {
    private val storeMenuViewModel by viewModels<StoreMenuViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_menu)

        lifecycleScope.launch {
            storeMenuViewModel.dummyData.collect {
                Log.d("DummyData", it.toString())
            }
        }
    }
}