package com.vsahin.daggerhiltexample.ui.main

import android.content.Context
import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.vsahin.daggerhiltexample.R
import com.vsahin.daggerhiltexample.data.MyResult
import com.vsahin.daggerhiltexample.data.repository.MainRepository
import dagger.hilt.android.qualifiers.ActivityContext

class MainViewModel @ViewModelInject constructor(
    private val repository: MainRepository,
    @ActivityContext activityContext: Context, // Let's say we need Activity context here
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val loadTrigger = MutableLiveData(Unit)
    val numberList: LiveData<MyResult<List<Int>>> = Transformations.switchMap(loadTrigger) {

        Log.d(TAG, activityContext.resources.getString(R.string.loading)) // Log string to check is the context really working

        repository.getNumberList()
    }

    fun refresh() {
        loadTrigger.value = Unit
    }

    companion object {
        private const val TAG: String = "MainViewModel"
    }
}