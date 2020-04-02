package com.example.testmircod.data

import dagger.Module
import dagger.Provides
import com.example.testmircod.data.gateway.VenuesGatewayImpl
import com.example.testmircod.data.network.Api
import com.example.testmircod.data.storage.database.AppDatabase
import com.example.testmircod.domain.gateway.VenuesGateway
import javax.inject.Singleton

@Module
class GatewayModule {

    @Provides
    @Singleton
    fun provideVenueGateway(api: Api, db: AppDatabase): VenuesGateway = VenuesGatewayImpl(api, db)

}