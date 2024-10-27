package com.example.myapplication

import com.example.myapplication.models.PropertyDetail
import com.example.myapplication.models.PropertyModel

class PropertyRepository {
    private val api = RetrofitInstance.api

    suspend fun getProperties(): List<PropertyModel> {
        return api.getProperties()
    }

    suspend fun getPropertyDetail(propertyId: String): PropertyDetail {
        return api.getPropertyDetail(propertyId)
    }
}
