package com.kyungeun.cleanarchitecture.data.repository

import com.kyungeun.cleanarchitecture.data.source.remote.api.RetrofitService
import com.kyungeun.cleanarchitecture.domain.model.GitRepos
import com.kyungeun.cleanarchitecture.domain.model.GitReposRequest
import com.kyungeun.cleanarchitecture.domain.repository.GitReposRepository
import javax.inject.Inject

class GitReposRepositoryImp @Inject constructor(
    private val retrofitService: RetrofitService
) : GitReposRepository {

    override suspend fun getGitReposRepository(gitReposRequest: GitReposRequest): List<GitRepos> {
        return retrofitService.getGitRepos(gitReposRequest.username)
    }
}