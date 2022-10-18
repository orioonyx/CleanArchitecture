package com.kyungeun.domain.repository

import com.kyungeun.domain.model.GithubRepo

interface GithubRepository {
    suspend fun getRepos(owner: String): List<GithubRepo>
}