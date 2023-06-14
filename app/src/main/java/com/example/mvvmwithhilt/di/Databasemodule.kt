package com.example.mvvmwithhilt.di

import android.content.Context
import androidx.room.Room
import com.example.mvvmwithhilt.db.DataDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class Databasemodule {


    @Provides
    fun provideFakerapi(@ApplicationContext context:Context):DataDB{
        return Room.databaseBuilder(context,DataDB::class.java,"DataDB").build()
    }
}