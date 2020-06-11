package com.vsahin.daggerhiltexample.data

import java.lang.Exception

sealed class MyResult<out T : Any> {
    data class Success<out T: Any>(val data: T) : MyResult<T>()
    data class Error(val exception: Exception) : MyResult<Nothing>()
    object Loading: MyResult<Nothing>()
}