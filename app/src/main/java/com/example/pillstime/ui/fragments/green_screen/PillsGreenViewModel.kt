package com.example.pillstime.ui.fragments.green_screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pillstime.data.local.database.AppDatabase
import com.example.pillstime.data.local.entity.model.PillsModel
import com.example.pillstime.data.repository.PillsRepository
import kotlinx.coroutines.launch

class PillsGreenViewModel(
private val pillsRepository: PillsRepository
) : ViewModel() {

    private val pillsList = MutableLiveData<List<PillsModel>>()

    fun getAllPills() = pillsRepository.getAllPills()

    fun insert(pills: PillsModel) = viewModelScope.launch {
        pillsRepository.insert(pills)
    }
    fun addPillToTop(pill: PillsModel) {
        val currentList = pillsList.value ?: emptyList()
        val updatedList = listOf(pill) + currentList
        pillsList.value = updatedList
    }
}