package com.example.mvvmwithhilt.di

import com.example.mvvmwithhilt.retrofit.FakeAPI
import com.example.mvvmwithhilt.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn
@Module
class NetworkModule {

    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Provides
    fun providesFakeAPI(retrofit: Retrofit): FakeAPI {
        return retrofit.create(FakeAPI::class.java)
    }
}