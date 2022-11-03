package com.kyungeun.cleanarchitecture.di.module

import com.kyungeun.cleanarchitecture.presentation.home.adapter.ReposAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object HomeModule {

    @Provides
    fun providePrayAdapter(): ReposAdapter {
        return ReposAdapter()
    }
}