package com.example.pillstime.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.pillstime.data.local.entity.model.PillsModel

@Dao
interface PillsDao {

    @Query("SELECT * FROM pills")
    fun getAllPills(): List<PillsModel>

    @Query("SELECT * FROM pills WHERE id = :id")
    fun getPillsById(id: Int): PillsModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPills(pills: PillsModel)

    @Delete
    fun deletePills(pills: PillsModel)

    @Update
    fun updatePills(pills: PillsModel)
}