package com.example.pillstime.data.repository

import androidx.lifecycle.LiveData
import com.example.pillstime.data.local.dao.PillsDao
import com.example.pillstime.data.local.entity.model.PillsModel

class PillsRepository(
    private val pillsDao: PillsDao
) {
    suspend fun insert(pills: PillsModel) {
        pillsDao.insertPills(pills)
    }

     fun getAllPills(): LiveData<List<PillsModel>> {
        return pillsDao.getAllPills()
    }
}