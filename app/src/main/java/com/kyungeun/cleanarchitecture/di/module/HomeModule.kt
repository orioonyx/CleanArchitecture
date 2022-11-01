package com.kyungeun.cleanarchitecture.di.module

import com.kyungeun.cleanarchitecture.presentation.home.adapter.PrayAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object HomeModule {

    @Provides
    fun providePrayAdapter(): PrayAdapter {
        return PrayAdapter()
    }
}