package com.example.testmircod.presentation.ui.imagedetail

import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import com.example.testmircod.base.BaseView
import com.example.testmircod.presentation.model.VenueModel

interface ImageDetailsView : BaseView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showImage(image: String)

}