package com.example.testmircod.data.storage.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.testmircod.data.storage.database.entity.VenueDbEntity

@Dao
interface VenueDao{
    @Query("SELECT * FROM venue")
    fun getAll(): List<VenueDbEntity?>?

    @Query("DELETE FROM venue")
    fun removeAll()

    @Query("DELETE FROM venue WHERE venue_id = :venueId")
    fun removeById(venueId: String): Int

    @Insert
    fun insert(venue: VenueDbEntity?)

    @Insert
    fun insertAll(vararg todo: VenueDbEntity)
}