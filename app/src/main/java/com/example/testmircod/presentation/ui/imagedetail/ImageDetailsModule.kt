package com.example.testmircod.presentation.ui.imagedetail

import dagger.Module
import dagger.Provides
import com.example.testmircod.presentation.model.VenueModel

@Module
class ImageDetailsModule{
    @Provides
    fun provideImage(fragment: ImageDetailsFragment):String  = fragment.getImage()
}