package com.kyungeun.cleanarchitecture.data.source.remote.api

import com.kyungeun.cleanarchitecture.domain.model.GitRepos
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {

    @GET("users/{username}/repos?sort=updated")
    suspend fun getGitRepos(@Path("username") username: String) : List<GitRepos>
}