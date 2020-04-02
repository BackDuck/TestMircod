package com.example.testmircod.domain.gateway

import io.reactivex.Completable
import io.reactivex.Single
import com.example.testmircod.domain.entity.VenueEntity

interface VenuesGateway  {

    fun getVenues(limit: Int, location: String, radius: Int): Single<List<VenueEntity>>

    fun getVenuePhotos(venueId: String): Single<List<String>>

    fun clearCache(): Completable

    fun clearCacheById(venueId: String): Completable
}