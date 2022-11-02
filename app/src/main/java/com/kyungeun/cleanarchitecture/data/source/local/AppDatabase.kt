package com.kyungeun.cleanarchitecture.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kyungeun.cleanarchitecture.data.source.local.dao.GitReposDao
import com.kyungeun.cleanarchitecture.data.source.local.entity.GitReposEntity

@Database(entities = [GitReposEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val gitReposDao: GitReposDao

    companion object {
        const val DB_NAME = "GithubDatabase.db"
    }
}