package com.ahmed.pro.cartmanagment.cartmenuexample.ui_model

val listName = arrayOf("Rice", "Tomato", "Test1", "Test2", "Apple")
val listPrices = arrayOf(10.5, 20.0, 30.0, 100.0, 36.0)

data class ItemModel(
    private val name: String = listName[(0..4).random()],
    private val price: Double = listPrices[(0..4).random()],
) {
    private var _counter = 0

    fun name() = name

    fun price() = price.toString().plus(" $")

    fun priceDouble() = price

    fun incrementCounter() = _counter++

    fun decrementCounter() = _counter--

    fun counter() = _counter

    fun counterStr() = _counter.toString()
}
