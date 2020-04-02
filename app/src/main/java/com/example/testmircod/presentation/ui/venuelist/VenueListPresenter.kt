package com.example.testmircod.presentation.ui.venuelist

import com.google.android.material.snackbar.Snackbar
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import com.example.testmircod.base.MoxyPresenter
import com.example.testmircod.cicerone.screens.ScreenFactory
import com.example.testmircod.domain.usecase.ClearAllChacheUseCase
import com.example.testmircod.domain.usecase.GetVenuesUseCase
import com.example.testmircod.presentation.ui.RootQualifier
import com.example.testmircod.presentation.model.VenueModel
import com.example.testmircod.presentation.model.VenueModelMapper
import com.example.testmircod.utils.cicerone.CustomRouter
import javax.inject.Inject

@InjectViewState
class VenueListPresenter @Inject constructor() : MoxyPresenter<VenueListView>() {

    @Inject
    @field:RootQualifier
    lateinit var router: CustomRouter

    @Inject
    lateinit var venueUseCase: GetVenuesUseCase

    @Inject
    lateinit var clearCacheUseCase: ClearAllChacheUseCase


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

    }

    fun locationReady(lat:Double?, lon: Double?){
        lat?.let {
            venueUseCase.getVenues("$lat,$lon", 500, 3)
                .map{VenueModelMapper.map(it)}
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    viewState.showProgress()
                }
                .doAfterTerminate {
                    viewState.hideProgress()
                }
                .subscribe({
                    viewState.showVenues(it)
                }, {
                    it.printStackTrace()
                })
                .disposeWhenDestroy()
        }
    }


    fun onVenueClick(model: VenueModel){
        router.navigateTo(ScreenFactory.getVenueDetailsScreen(model))
    }

    fun onClearCacheClick(){
        clearCacheUseCase.clearChache()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.showSnackBar("Кэш очищен, данные будут автоматически обновлены", Snackbar.LENGTH_SHORT)
            },{
                viewState.showSnackBar("Не удалось очистить кэш", Snackbar.LENGTH_SHORT)
            })
            .disposeWhenDestroy()

        viewState.showProgress()
        viewState.requestLocation()
    }

    fun refresh(){
        viewState.showProgress()
        viewState.requestLocation()
    }


}