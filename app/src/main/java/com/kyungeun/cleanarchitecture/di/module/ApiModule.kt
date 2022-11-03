package com.kyungeun.cleanarchitecture.di.module

import com.kyungeun.cleanarchitecture.data.source.remote.api.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    fun provideRetrofit(retrofit: Retrofit): RetrofitService = retrofit.create(RetrofitService::class.java)

}