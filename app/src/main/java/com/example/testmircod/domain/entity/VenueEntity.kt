package com.example.testmircod.domain.entity


data class VenueEntity(
    val id: String,
    val name: String,
    val address: String,
    val distance: Int,
    val category: String,
    val categoryIcon: String,
    val postalCode: String,
    val lat: Double,
    val lon: Double


)
