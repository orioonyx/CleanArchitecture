package com.kyungeun.cleanarchitecture.data.source.local.dao

import androidx.room.*
import com.kyungeun.cleanarchitecture.data.source.local.entity.GitReposEntity

@Dao
interface GitReposDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(gitrepos: List<GitReposEntity>)

    @Query("SELECT * FROM GitRepos")
    fun getGitRepos(): List<GitReposEntity>

}