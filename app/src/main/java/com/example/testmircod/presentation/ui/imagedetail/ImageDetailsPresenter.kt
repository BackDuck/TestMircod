package com.example.testmircod.presentation.ui.imagedetail

import com.google.android.material.snackbar.Snackbar
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import com.example.testmircod.base.MoxyPresenter
import com.example.testmircod.domain.usecase.ClearChacheByIdUseCase
import com.example.testmircod.presentation.ui.RootQualifier
import com.example.testmircod.presentation.model.VenueModel
import com.example.testmircod.utils.cicerone.CustomRouter
import javax.inject.Inject

@InjectViewState
class ImageDetailsPresenter @Inject constructor() : MoxyPresenter<ImageDetailsView>() {

    @Inject
    @field:RootQualifier
    lateinit var router: CustomRouter

    @field:Inject
    @field:JvmField
    var image: String = ""

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
            viewState.showImage(image)
    }


}