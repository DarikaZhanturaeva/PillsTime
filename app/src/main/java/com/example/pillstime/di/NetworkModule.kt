package com.example.pillstime.di

import android.content.Context
import androidx.room.Room
import com.example.pillstime.data.local.dao.PillsDao
import com.example.pillstime.data.local.database.AppDatabase
import org.koin.dsl.module

val networkModule = module {

    single { provideDao(get()) }
    single { provideDatabase(get()) }

}

fun provideDao(database: AppDatabase): PillsDao {
    return database.pillsDao()
}

fun provideDatabase(
    context: Context
) = Room.databaseBuilder(
    context,
    AppDatabase::class.java,
    "home_data"
).allowMainThreadQueries().build()