package com.vsahin.daggerhiltexample.data.repository

import androidx.lifecycle.MutableLiveData
import com.vsahin.daggerhiltexample.data.MyResult
import dagger.Reusable
import java.util.concurrent.Executors
import javax.inject.Inject
import kotlin.random.Random

@Reusable
class MainRepository @Inject constructor() {
    fun getNumberList(): MutableLiveData<MyResult<List<Int>>> {
        val myResource: MutableLiveData<MyResult<List<Int>>> = MutableLiveData(MyResult.Loading)

        Executors.newSingleThreadExecutor().execute {
            Thread.sleep(SIMULATE_NETWORK_DELAY)
            if (Random.nextInt(2) % 2 == 0) {
                myResource.postValue(MyResult.Error(Exception()))
                return@execute
            }
            val numberList = (1..10).map { Random.nextInt(20) }
            myResource.postValue(MyResult.Success(numberList))
        }

        return myResource
    }

    fun getNumber(id: Int): MutableLiveData<MyResult<Int>> {
        val myResource: MutableLiveData<MyResult<Int>> = MutableLiveData(MyResult.Loading)

        Executors.newSingleThreadExecutor().execute {
            Thread.sleep(SIMULATE_NETWORK_DELAY)
            if (Random.nextInt(2) % 2 == 0) {
                myResource.postValue(MyResult.Error(Exception()))
                return@execute
            }
            myResource.postValue(MyResult.Success(id))
        }

        return myResource

    }

    companion object {
        private const val SIMULATE_NETWORK_DELAY: Long = 2000
    }
}