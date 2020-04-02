package com.example.testmircod.presentation.ui

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.example.testmircod.presentation.ui.imagedetail.ImageDetailsFragment
import com.example.testmircod.presentation.ui.imagedetail.ImageDetailsModule
import com.example.testmircod.presentation.ui.venuedetails.VenueDetailsFragment
import com.example.testmircod.presentation.ui.venuedetails.VenueDetailsModule
import com.example.testmircod.presentation.ui.venuelist.VenueListFragment
import com.example.testmircod.presentation.ui.venuelist.VenueListModule

@Module
abstract class RootFragmentBuilder {

    @ContributesAndroidInjector(modules = [VenueListModule::class])
    abstract fun provideVenueListFragment(): VenueListFragment

    @ContributesAndroidInjector(modules = [VenueDetailsModule::class])
    abstract fun provideVenueDetailsFragment(): VenueDetailsFragment

    @ContributesAndroidInjector(modules = [ImageDetailsModule::class])
    abstract fun provideImageDetailsFragment(): ImageDetailsFragment
}