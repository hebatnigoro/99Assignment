package com.example.myapplication

import com.example.myapplication.models.PropertyDetail
import com.example.myapplication.models.PropertyModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

val retrofit = Retrofit.Builder()
    .baseUrl("https://ninetyninedotco-b7299.asia-southeast1.firebasedatabase.app/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val propertyApi = retrofit.create(PropertyApi::class.java)

interface PropertyApi {
    @GET("listings.json")
    suspend fun getProperties(): List<PropertyModel>

    @GET("details/{id}.json")
    suspend fun getPropertyDetail(@Path("id") propertyId: String): PropertyDetail
}

