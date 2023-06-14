package com.example.mvvmwithhilt.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.mvvmwithhilt.models.Products
import com.example.mvvmwithhilt.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository )   :ViewModel() {
    val productsLiveData : LiveData<List<Products>>
        get() = repository.products

    init {
  viewModelScope.launch {
    repository.getProducts()
  }
    }
}
