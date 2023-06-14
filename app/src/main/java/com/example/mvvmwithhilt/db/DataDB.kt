package com.example.mvvmwithhilt.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvmwithhilt.models.Products

@Database(entities = [Products::class], version = 1)
abstract class DataDB:RoomDatabase() {
    abstract fun getFakerDao():DataDao
}