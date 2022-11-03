package com.kyungeun.cleanarchitecture.di.module

import android.app.Application
import androidx.room.Room
import com.kyungeun.cleanarchitecture.data.source.local.AppDatabase
import com.kyungeun.cleanarchitecture.data.source.local.dao.GitReposDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    internal fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            AppDatabase.DB_NAME
        ).allowMainThreadQueries().build()
    }

    @Provides
    internal fun provideGitReposDao(appDatabase: AppDatabase): GitReposDao {
        return appDatabase.gitReposDao
    }
}
