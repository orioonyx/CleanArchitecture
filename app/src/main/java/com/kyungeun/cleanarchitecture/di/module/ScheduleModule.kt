package com.kyungeun.cleanarchitecture.di.module

import com.kyungeun.cleanarchitecture.data.schedule.repository.ScheduleRepositoryImpl
import com.kyungeun.cleanarchitecture.domain.schedule.repository.ScheduleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ScheduleModule {

    @Binds
    abstract fun bindScheduleRepository(scheduleRepositoryImpl: ScheduleRepositoryImpl): ScheduleRepository
}