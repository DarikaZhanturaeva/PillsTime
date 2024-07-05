package com.example.pillstime.data.local.entity.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pills")
data class PillsModel(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val title : String,
    val time : String,
    val description : String
)
