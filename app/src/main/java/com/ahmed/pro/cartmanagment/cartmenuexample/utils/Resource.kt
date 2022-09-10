package com.ahmed.pro.cartmanagment.cartmenuexample.utils

data class Resource<out T>(
    var status: Status,
    val data: T? = null,
    var message: String? = null
) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(
                Status.SUCCESS,
                data,
                null
            )
        }

        fun <T> error(error: String, data: T? = null): Resource<T> {
            return Resource(
                status = Status.ERROR,
                data = data,
                message = error
            )
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(
                Status.LOADING,
                data,
                null
            )
        }

        fun empty(): Resource<Nothing> {
            return Resource(
                Status.EMPTY,
                null,
                null
            )
        }
    }
}