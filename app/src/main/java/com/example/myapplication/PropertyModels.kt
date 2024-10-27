package com.example.myapplication.models

data class Address(
    val district: String,
    val streetname: String
)

data class Attributes(
    val area_size: Int,
    val bathrooms: Int,
    val bedrooms: Int,
    val price: Int
)

data class PropertyModel(
    val id: Int,
    val project_name: String,
    val category: String,
    val completed_at: String,
    val tenure: Int,
    val photo: String,
    val address: Address,
    val attributes: Attributes
)

data class MapCoordinates(
    val lat: Double,
    val lng: Double
)

data class DetailAddress(
    val title: String,
    val subtitle: String,
    val map_coordinates: MapCoordinates
)

data class PropertyDetailItem(
    val label: String,
    val text: String
)


data class PropertyDetail(
    val id: Int,
    val project_name: String,
    val description: String,
    val photo: String,
    val address: DetailAddress,
    val attributes: Attributes,
    val property_details: List<PropertyDetailItem>
)

