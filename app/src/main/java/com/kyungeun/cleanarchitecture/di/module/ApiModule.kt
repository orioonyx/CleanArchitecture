package com.kyungeun.cleanarchitecture.di.module

import com.kyungeun.cleanarchitecture.data.schedule.api.PrayApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    fun providePrayApi(retrofit: Retrofit): PrayApi = retrofit.create(PrayApi::class.java)

}