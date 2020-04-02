package com.example.testmircod.presentation.ui.imagedetail

import androidx.fragment.app.Fragment
import com.example.testmircod.presentation.model.VenueModel
import ru.terrakok.cicerone.android.support.SupportAppScreen

class ImageDetailsScreen internal constructor(val image: String) :  SupportAppScreen() {

    override fun getFragment(): Fragment {
        return ImageDetailsFragment.getInstance(image)
    }

    override fun getScreenKey(): String {
        return "${ImageDetailsFragment::class}"
    }

}