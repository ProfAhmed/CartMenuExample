package com.ahmed.pro.cartmanagment.cartmenuexample.di

import com.ahmed.pro.cartmanagment.cartmenuexample.data_layer.StoreMenuRepositoryImp
import com.ahmed.pro.cartmanagment.cartmenuexample.domain_layer.StoreMenuRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideStoreMenuRepository(storeMenuRepositoryImp: StoreMenuRepositoryImp): StoreMenuRepository
}