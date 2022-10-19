package com.kyungeun.data

import com.kyungeun.data.source.GithubRemoteSource
import com.kyungeun.domain.model.GithubRepo
import com.kyungeun.domain.repository.GithubRepository
import javax.inject.Inject


class GithubRepositoryImpl @Inject constructor(
    private val githubRemoteSource: GithubRemoteSource
) : GithubRepository {

    override suspend fun getRepos(owner: String): List<GithubRepo> {
        return githubRemoteSource.getRepos(owner)
    }
}