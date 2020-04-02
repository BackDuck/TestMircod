package com.example.testmircod.presentation.ui.venuelist

import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import com.example.testmircod.base.BaseView
import com.example.testmircod.presentation.model.VenueModel

interface VenueListView : BaseView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showVenues(items: List<VenueModel>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun requestLocation()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showProgress()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun hideProgress()

}