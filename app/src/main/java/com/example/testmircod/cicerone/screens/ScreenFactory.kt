package com.example.testmircod.cicerone.screens

import com.example.testmircod.presentation.model.VenueModel
import com.example.testmircod.presentation.ui.venuedetails.VenueDetailsScreen
import com.example.testmircod.presentation.ui.venuelist.VenueListScreen
import ru.terrakok.cicerone.android.support.SupportAppScreen
import com.example.testmircod.presentation.ui.imagedetail.ImageDetailsFragment
import com.example.testmircod.presentation.ui.imagedetail.ImageDetailsScreen


object ScreenFactory {

    fun getVenueListScreen(): SupportAppScreen = VenueListScreen()

    fun getVenueDetailsScreen(venueModel: VenueModel): SupportAppScreen = VenueDetailsScreen(venueModel)

    fun getImageDetailsScreen(image: String): SupportAppScreen = ImageDetailsScreen(image)

}