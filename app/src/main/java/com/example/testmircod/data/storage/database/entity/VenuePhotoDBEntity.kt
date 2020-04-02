package com.example.testmircod.data.storage.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photo")
data class VenuePhotoDBEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    var venue_id: String,

    var url: String
)
