package com.vsahin.daggerhiltexample.ui.detail

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.vsahin.daggerhiltexample.data.MyResult
import com.vsahin.daggerhiltexample.data.repository.MainRepository

class DetailViewModel @ViewModelInject constructor(
    private val repository: MainRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val idLiveData = MutableLiveData<Int>()

    val number: LiveData<MyResult<Int>> = Transformations.switchMap(idLiveData) {
        repository.getNumber(it)
    }

    fun setId(id: Int) {
        idLiveData.value = id
    }
}