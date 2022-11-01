package com.kyungeun.cleanarchitecture.data.database.pray

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kyungeun.cleanarchitecture.data.database.pray.dao.PrayDao
import com.kyungeun.cleanarchitecture.data.database.pray.model.PrayEntity

@Database(
    version = 1,
    entities = [PrayEntity::class],
    exportSchema = true
)
abstract class MyRoomDatabase : RoomDatabase() {

    abstract fun prayDao(): PrayDao
}