package com.example.testmircod.data.storage.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testmircod.data.storage.database.dao.VenueDao
import com.example.testmircod.data.storage.database.dao.VenuePhotoDao
import com.example.testmircod.data.storage.database.entity.VenueDbEntity
import com.example.testmircod.data.storage.database.entity.VenuePhotoDBEntity

@Database(entities = [VenueDbEntity::class, VenuePhotoDBEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun venueDao(): VenueDao
    abstract fun venuePhotoDao(): VenuePhotoDao
}