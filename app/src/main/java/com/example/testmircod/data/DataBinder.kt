package com.example.testmircod.data

import dagger.Binds
import dagger.Module
import com.example.testmircod.data.storage.DataStorage
import com.example.testmircod.data.storage.DataStorageImpl

@Module
abstract class DataBinder {

    @Binds
    abstract fun bindDataStorage(dataStorageImpl: DataStorageImpl): DataStorage

}