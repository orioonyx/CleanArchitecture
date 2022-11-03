package com.kyungeun.cleanarchitecture.di.module

import com.kyungeun.cleanarchitecture.data.repository.GitReposRepositoryImp
import com.kyungeun.cleanarchitecture.domain.repository.GitReposRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class GitReposModule {

    @Binds
    abstract fun bindReposRepository(gitReposRepositoryImp: GitReposRepositoryImp): GitReposRepository
}