package com.example.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class ListingDetailViewModel : ViewModel() {
    private val repository = PropertyRepository()

    fun getPropertyDetail(propertyId: String) = liveData(Dispatchers.IO) {
        val response = repository.getPropertyDetail(propertyId)
        emit(response)
    }
}

