package com.theandroidfactory.ricknmorty

import retrofit2.Response

data class MyResponse<T>(
    val status: Status,
    val data: Response<T>?,
    val exception: Exception?
) {
    sealed class Status {
        object Success : Status()
        object Failure : Status()
    }

    val failed: Boolean
        get() = this.status == Status.Failure
    val isSuccessful: Boolean
        get() = !failed && this.data?.isSuccessful == true
    val body: T
        get() = this.data!!.body()!!

    companion object {
        fun<T> success(data: Response<T>) = MyResponse<T>(Status.Success, data, null)

        fun<T> failure(exception: Exception) = MyResponse<T>(Status.Failure, null, exception)
    }
}