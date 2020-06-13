package com.vsahin.daggerhiltexample.ui

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.vsahin.daggerhiltexample.data.repository.MainRepository

class SharedViewModel @ViewModelInject constructor(
    private val repository: MainRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val randomNumber = MutableLiveData<Int>()
}