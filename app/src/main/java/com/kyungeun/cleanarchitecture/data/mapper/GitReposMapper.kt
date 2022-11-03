package com.kyungeun.cleanarchitecture.data.mapper

import com.kyungeun.cleanarchitecture.data.source.local.entity.GitReposEntity
import com.kyungeun.cleanarchitecture.domain.model.GitRepos

fun GitRepos.toEntity() = GitReposEntity(
    id = id,
    name = name,
    description = description,
    html_url = html_url
)