package com.example.testmircod.presentation.ui

import moxy.InjectViewState
import com.example.testmircod.base.MoxyPresenter
import com.example.testmircod.cicerone.screens.ScreenFactory
import com.example.testmircod.utils.cicerone.CustomRouter
import javax.inject.Inject

@InjectViewState
class RootPresenter @Inject constructor() : MoxyPresenter<RootView>()  {

    @field:RootQualifier
    @field:Inject
    lateinit var router: CustomRouter

    fun onCreate(isRestore: Boolean) {

    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun allPermissionsGranted(){
        router.newRootScreen(ScreenFactory.getVenueListScreen())
    }
}