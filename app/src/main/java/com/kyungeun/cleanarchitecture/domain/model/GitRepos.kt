package com.kyungeun.cleanarchitecture.domain.model

data class GitRepos(
    val id: Int,
    val name: String,
    val description: String,
    val html_url: String?
)