package com.example.testmircod.data

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import dagger.Module
import dagger.Provides
import com.example.testmircod.data.network.NetworkModule
import com.example.testmircod.data.storage.database.AppDatabase
import javax.inject.Named

@Module(includes = [DataBinder::class, NetworkModule::class, GatewayModule::class])
class DataModule {

    companion object {
        private const val KEY_PREFERENCES = "user_preferences"
    }

    @Provides
    @Named("userPreferences")
    fun provideDataPreferences(context: Context): SharedPreferences =
            context.getSharedPreferences(KEY_PREFERENCES, Context.MODE_PRIVATE)

    @Provides
    fun provideDatabase(applicationContext: Context): AppDatabase = Room.databaseBuilder(
    applicationContext,
    AppDatabase::class.java, "venue-db.db"
    ).build()


}