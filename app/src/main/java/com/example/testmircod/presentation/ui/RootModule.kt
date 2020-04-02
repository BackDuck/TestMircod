package com.example.testmircod.presentation.ui

import dagger.Module
import dagger.Provides
import com.example.testmircod.cicerone.animated.AnimatedNavigator
import com.example.testmircod.utils.cicerone.CustomRouter
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder

@Module(includes = [RootFragmentBuilder::class])
class RootModule {

    @Provides
    @RootScope
    @RootQualifier
    fun provideRootCicerone(@RootQualifier router: CustomRouter): Cicerone<CustomRouter> = Cicerone.create(router)

    @Provides
    @RootQualifier
    fun provideRootNavigatorHolder(@RootQualifier cicerone: Cicerone<CustomRouter>): NavigatorHolder =
        cicerone.navigatorHolder

    @Provides
    @RootQualifier
    fun provideRegistrationNavigator(activity: RootActivity): Navigator =
        AnimatedNavigator(activity, activity.containerId)

}

