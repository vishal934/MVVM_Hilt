package com.example.mvvmwithhilt.retrofit

import com.example.mvvmwithhilt.models.Products
import retrofit2.Response
import retrofit2.http.GET

interface FakeAPI {

    @GET("products")
    suspend fun getProducts():Response<List<Products>>

}