package com.example.mvvmwithhilt.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mvvmwithhilt.models.Products

@Dao
interface DataDao {

    @Insert
    suspend fun addProducts(products: List<Products>)

    @Query("SELECT * FROM Products")
    suspend fun getProduct():List<Products>
}