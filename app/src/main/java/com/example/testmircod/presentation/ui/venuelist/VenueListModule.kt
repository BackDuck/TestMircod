package com.example.testmircod.presentation.ui.venuelist

import dagger.Module
import dagger.Provides

@Module
class VenueListModule{
    @Provides
    fun provideVenueListAdapter():VenueRecyclerviewAdapter  = VenueRecyclerviewAdapter()
}