package com.example.testmircod.presentation.ui.venuedetails

import dagger.Module
import dagger.Provides
import com.example.testmircod.presentation.model.VenueModel

@Module
class VenueDetailsModule{
    @Provides
    fun provideVenue(fragment: VenueDetailsFragment):VenueModel?  = fragment.getVenueModel()
}