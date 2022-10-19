package com.kyungeun.data.service

import com.kyungeun.data.model.GithubRepoRes
import retrofit2.http.*

interface GithubService {

    @GET("users/{owner}/repos")
    suspend fun getRepos(@Path("owner") owner: String) : List<GithubRepoRes>
}