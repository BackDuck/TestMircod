package com.example.testmircod.di.modules

import dagger.Module
import dagger.Provides
import com.example.testmircod.presentation.ui.RootQualifier
import com.example.testmircod.utils.cicerone.CustomRouter
import javax.inject.Singleton

@Module
class CiceroneModule {

    @Provides
    @Singleton
    @RootQualifier
    fun provideRootRouter(): CustomRouter = CustomRouter()

}