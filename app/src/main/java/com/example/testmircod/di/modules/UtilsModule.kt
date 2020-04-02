package com.example.testmircod.di.modules

import android.app.usage.UsageEvents
import dagger.Module
import dagger.Provides
import io.reactivex.subjects.PublishSubject
import javax.inject.Singleton


@Module
class UtilsModule {

    @Singleton
    @Provides
    fun provideEventProvider(): PublishSubject<UsageEvents.Event> = PublishSubject.create()


}