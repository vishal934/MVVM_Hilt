package com.example.mvvmwithhilt.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmwithhilt.db.DataDB
import com.example.mvvmwithhilt.models.Products
import com.example.mvvmwithhilt.retrofit.FakeAPI
import com.google.android.gms.analytics.ecommerce.Product
import javax.inject.Inject


class Repository @Inject constructor(private val fakeAPI: FakeAPI, private val dataDB: DataDB){

    private val _products = MutableLiveData<List<Products>>()
    val products: LiveData<List<Products>>
        get() = _products

    suspend fun getProducts(){
        val result = fakeAPI.getProducts()
        if(result.isSuccessful && result.body() != null){
            dataDB.getFakerDao().addProducts(result.body()!!)
            _products.postValue(result.body())
        }
    }
}