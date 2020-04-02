package com.example.testmircod.data.storage.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "venue")
data class VenueDbEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    var venue_id: String,

    val name: String,

    val address: String,

    val distance: Int,

    val category: String,

    val categoryIcon: String,

    val postalCode: String,

    val lat: Double,

    val lon: Double
)
