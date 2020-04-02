package com.example.testmircod.presentation.ui.venuedetails

import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import com.example.testmircod.base.BaseView
import com.example.testmircod.presentation.model.VenueModel

interface VenueDetailsView : BaseView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showVenueDetails(details: VenueModel)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showPositionOnMap(lat: Double, lon: Double, name: String)

}