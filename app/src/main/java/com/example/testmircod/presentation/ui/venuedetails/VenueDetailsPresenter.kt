package com.example.testmircod.presentation.ui.venuedetails

import com.google.android.material.snackbar.Snackbar
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import com.example.testmircod.base.MoxyPresenter
import com.example.testmircod.cicerone.screens.ScreenFactory
import com.example.testmircod.domain.usecase.ClearChacheByIdUseCase
import com.example.testmircod.presentation.ui.RootQualifier
import com.example.testmircod.presentation.model.VenueModel
import com.example.testmircod.utils.cicerone.CustomRouter
import javax.inject.Inject

@InjectViewState
class VenueDetailsPresenter @Inject constructor() : MoxyPresenter<VenueDetailsView>() {

    @Inject
    @field:RootQualifier
    lateinit var router: CustomRouter

    @field:Inject
    @field:JvmField
    var venueModel: VenueModel? = null

    @Inject
    lateinit var clearCacheUseCase: ClearChacheByIdUseCase


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        venueModel?.let {
            viewState.showVenueDetails(it)
        }

    }

    fun onClearCacheClick() {
        venueModel?.let { model ->
            clearCacheUseCase
                .clearChache(model.id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        viewState.showSnackBar(
                            "${model.name} удален из кэша",
                            Snackbar.LENGTH_SHORT
                        )
                    },
                    {
                        viewState.showSnackBar(
                            "Не удалось удалить ${model.name} из кэша",
                            Snackbar.LENGTH_SHORT
                        )
                    }
                ).disposeWhenDestroy()
        }
    }

    fun mapIsReady(){
        venueModel?.let {
            viewState.showPositionOnMap(it.lat, it.lon, it.name)
        }
    }

    fun onImageClick(image: String){
        router.navigateTo(ScreenFactory.getImageDetailsScreen(image))
    }

}