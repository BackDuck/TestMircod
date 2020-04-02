package com.example.testmircod

import androidx.multidex.MultiDex
import com.example.testmircod.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.reactivex.plugins.RxJavaPlugins

class App: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<App> {
        return DaggerAppComponent.builder().application(this).create(this)
    }

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
        RxJavaPlugins.setErrorHandler {
            it.printStackTrace()
        }
    }
}