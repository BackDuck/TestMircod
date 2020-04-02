package com.example.testmircod.presentation.ui.venuelist

import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class VenueListScreen internal constructor() :  SupportAppScreen() {

    override fun getFragment(): Fragment {
        return VenueListFragment.getInstance()
    }

    override fun getScreenKey(): String {
        return "${VenueListFragment::class}"
    }

}