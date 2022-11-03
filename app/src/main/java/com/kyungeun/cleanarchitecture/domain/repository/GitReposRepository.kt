package com.kyungeun.cleanarchitecture.domain.repository

import com.kyungeun.cleanarchitecture.domain.model.GitRepos
import com.kyungeun.cleanarchitecture.domain.model.GitReposRequest

interface GitReposRepository {

    suspend fun getGitReposRepository(gitReposRequest: GitReposRequest): List<GitRepos>
}