package com.vsahin.daggerhiltexample.ui.main

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.vsahin.daggerhiltexample.data.MyResult
import com.vsahin.daggerhiltexample.data.repository.MainRepository

class MainViewModel @ViewModelInject constructor(
    private val repository: MainRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val loadTrigger = MutableLiveData(Unit)
    val numberList: LiveData<MyResult<List<Int>>> = Transformations.switchMap(loadTrigger) {
        repository.getNumberList()
    }

    fun refresh() {
        loadTrigger.value = Unit
    }
}