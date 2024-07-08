package com.example.pillstime.di

import com.example.pillstime.data.repository.PillsRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoryModule : Module = module {

    single { PillsRepository(get()) }

}