package com.vsahin.daggerhiltexample.data.repository

import androidx.lifecycle.MutableLiveData
import com.vsahin.daggerhiltexample.data.MyResult
import dagger.Reusable
import java.util.*
import javax.inject.Inject

@Reusable
class MainRepository @Inject constructor() {
    fun getNumberList(): MutableLiveData<MyResult<List<Int>>> {
        val myResource: MutableLiveData<MyResult<List<Int>>> = MutableLiveData(MyResult.Loading)

        Thread(Runnable {
            Thread.sleep(SIMULATE_NETWORK_DELAY)
            val random = Random()
            val numberList = (1..10).map { random.nextInt() }
            myResource.postValue(MyResult.Success(numberList))
        }).start()

        return myResource
    }

    companion object {
        private const val SIMULATE_NETWORK_DELAY: Long = 2000
    }
}