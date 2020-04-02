package com.example.testmircod.di.components

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import com.example.testmircod.App
import com.example.testmircod.data.DataModule
import com.example.testmircod.di.modules.AppModule
import com.example.testmircod.di.modules.CiceroneModule
import com.example.testmircod.di.modules.UtilsModule
import com.example.testmircod.di.modules.builder.ActivityBuilder
import com.example.testmircod.di.modules.builder.FragmentBuilder
import com.example.testmircod.di.modules.builder.ServiceBuilder
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DataModule::class,
        CiceroneModule::class,
        AppModule::class,
        UtilsModule::class,
        FragmentBuilder::class,
        ServiceBuilder::class,
        ActivityBuilder::class,
        AndroidSupportInjectionModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>() {

        @BindsInstance
        abstract fun application(application: Application): Builder

    }

}