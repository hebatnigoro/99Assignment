package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.models.PropertyModel
import kotlinx.coroutines.launch

class SearchResultViewModel : ViewModel() {
    private val repository = PropertyRepository()

    private val _properties = MutableLiveData<List<PropertyModel>>()
    val properties: LiveData<List<PropertyModel>> get() = _properties

    init {
        fetchProperties()
    }

    private fun fetchProperties() {
        viewModelScope.launch {
            try {
                val response = repository.getProperties()
                _properties.postValue(response)
            } catch (e: Exception) {
                //handle error here
            }
        }
    }
}
