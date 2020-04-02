package com.example.testmircod.domain.usecase

import io.reactivex.Completable
import com.example.testmircod.domain.gateway.VenuesGateway
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ClearChacheByIdUseCase @Inject constructor(private val venuesGateway: VenuesGateway) {

    fun clearChache(venueId: String): Completable {
        return venuesGateway.clearCacheById(venueId)
    }
}