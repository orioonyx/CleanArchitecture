package com.kyungeun.cleanarchitecture.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "GitRepos")
class GitReposEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val description: String,
    val html_url: String?
)