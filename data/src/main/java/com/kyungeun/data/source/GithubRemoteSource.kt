package com.kyungeun.data.source

import com.kyungeun.data.model.GithubRepoRes
import com.kyungeun.data.service.GithubService
import javax.inject.Inject

interface GithubRemoteSource {
    suspend fun getRepos(owner: String): List<GithubRepoRes>
}

class GithubRemoteSourceImpl @Inject constructor(
    private val githubService: GithubService
) : GithubRemoteSource {

    override suspend fun getRepos(owner: String): List<GithubRepoRes> {
        return githubService.getRepos(owner)
    }
}