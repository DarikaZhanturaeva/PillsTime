package com.example.pillstime.di

import com.example.pillstime.ui.fragments.green_screen.PillsGreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule : Module = module {

    viewModel { PillsGreenViewModel(get()) }

}
