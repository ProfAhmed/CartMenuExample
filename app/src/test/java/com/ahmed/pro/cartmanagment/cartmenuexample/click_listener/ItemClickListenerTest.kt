package com.ahmed.pro.cartmanagment.cartmenuexample.click_listener

import com.ahmed.pro.cartmanagment.cartmenuexample.ui_model.ItemModel
import com.ahmed.pro.cartmanagment.cartmenuexample.utils.calculateTotal
import org.junit.Assert
import org.junit.Test

class ItemClickListenerTest {
    private val item1 = ItemModel("item0", 10.0)
    private val item2 = ItemModel("item0", 10.0)
    private val dummyList = mutableListOf(
        item1, item2
    )

    @Test
    fun `onClickAddNewItem() calculate when add new item`() {
        //arrange
        val newItem = ItemModel("newItem", 10.0)
        dummyList.add(newItem)

        //act
        val actualResult = calculateTotal(dummyList)

        Assert.assertEquals(30.0, actualResult, 0.0)
    }

    @Test
    fun `onClickAddNewItem() calculate when delete an item`() {
        //arrange
        dummyList.remove(item1)

        //act
        val actualResult = calculateTotal(dummyList)

        Assert.assertEquals(10.0, actualResult, 0.0)
    }

    @Test
    fun `onClickClearAll() calculate when clear all items`() {
        //arrange
        dummyList.clear()

        //act
        val actualResult = calculateTotal(dummyList)

        Assert.assertEquals(0.0, actualResult, 0.0)
    }

}