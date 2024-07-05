package com.example.pillstime.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pillstime.data.local.dao.PillsDao
import com.example.pillstime.data.local.entity.model.PillsModel

@Database(entities = [PillsModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pillsDao(): PillsDao
}