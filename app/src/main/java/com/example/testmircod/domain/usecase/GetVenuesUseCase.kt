package com.example.testmircod.domain.usecase

import io.reactivex.Observable
import com.example.testmircod.domain.entity.VenueEntity
import com.example.testmircod.domain.gateway.VenuesGateway
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetVenuesUseCase @Inject constructor(private val venuesGateway: VenuesGateway) {

    fun getVenues(location: String, radius: Int, limit: Int = 20): Observable<Pair<VenueEntity, List<String>>> {
        return venuesGateway.getVenues(limit, location, radius)
            .flatMapObservable {
                Observable.fromIterable(it)
                    .concatMapSingle { venue->
                        venuesGateway.getVenuePhotos(venue.id)
                            .map { venuePhoto ->
                                venue to venuePhoto
                            }
                    }
            }
    }
}