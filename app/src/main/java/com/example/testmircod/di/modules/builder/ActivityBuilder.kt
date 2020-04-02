package com.example.testmircod.di.modules.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.example.testmircod.presentation.ui.RootActivity
import com.example.testmircod.presentation.ui.RootModule
import com.example.testmircod.presentation.ui.RootScope

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [RootModule::class])
    @RootScope
    abstract fun provideRootActivity(): RootActivity

}