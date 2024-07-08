package com.example.pillstime.data.local.dao

import androidx.lifecycle.LiveData
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
    fun getAllPills(): LiveData<List<PillsModel>>

    @Query("SELECT * FROM pills WHERE id = :id")
    fun getPillsById(id: Int): PillsModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPills(pills: PillsModel)

    @Delete
    suspend fun deletePills(pills: PillsModel)

    @Update
    suspend fun updatePills(pills: PillsModel)
}