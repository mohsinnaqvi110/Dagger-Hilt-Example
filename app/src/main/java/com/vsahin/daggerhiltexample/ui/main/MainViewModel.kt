package com.vsahin.daggerhiltexample.ui.main

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.vsahin.daggerhiltexample.data.MyResult
import com.vsahin.daggerhiltexample.data.repository.MainRepository

class MainViewModel @ViewModelInject constructor(
    repository: MainRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private var _numberList = MutableLiveData<MyResult<List<Int>>>()
    val numberList: LiveData<MyResult<List<Int>>>
        get() = _numberList

    init {
        _numberList = repository.getNumberList()
    }
}