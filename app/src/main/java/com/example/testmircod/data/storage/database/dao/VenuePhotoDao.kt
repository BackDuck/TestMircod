package com.example.testmircod.data.storage.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.testmircod.data.storage.database.entity.VenuePhotoDBEntity

@Dao
interface VenuePhotoDao{

    @Query("SELECT * FROM photo")
    fun getAll(): List<VenuePhotoDBEntity?>?

    @Query("DELETE FROM photo")
    fun removeAll()

    @Query("DELETE FROM photo WHERE venue_id = :venueId")
    fun removeById(venueId: String)

    @Insert
    fun insert(venue: VenuePhotoDBEntity?)

    @Query("SELECT * FROM photo WHERE venue_id = :venueId")
    fun getById(venueId: String): List<VenuePhotoDBEntity>?
}