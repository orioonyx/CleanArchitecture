package com.kyungeun.cleanarchitecture.presentation.home

import com.kyungeun.cleanarchitecture.domain.model.GitRepos


data class HomeItemUiState(
    val gitRepos: List<GitRepos>
)