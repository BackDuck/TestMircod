package com.example.testmircod.presentation.ui.venuedetails

import androidx.fragment.app.Fragment
import com.example.testmircod.presentation.model.VenueModel
import ru.terrakok.cicerone.android.support.SupportAppScreen

class VenueDetailsScreen internal constructor(val venueModel: VenueModel) :  SupportAppScreen() {

    override fun getFragment(): Fragment {
        return VenueDetailsFragment.getInstance(venueModel)
    }

    override fun getScreenKey(): String {
        return "${VenueDetailsFragment::class}"
    }

}