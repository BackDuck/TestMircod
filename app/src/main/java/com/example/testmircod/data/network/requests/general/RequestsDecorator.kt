package com.example.testmircod.data.network.requests.general

import io.reactivex.Single
import com.example.testmircod.data.network.pojo.response.venues.VenuesResponse
import com.example.testmircod.data.network.pojo.response.venuesphoto.VenuesPhotoResponse

abstract class RequestsDecorator(private val requests: Requests) : Requests {

    override fun getVenuePhotos(
        venueId: String,
        clientId: String,
        clientSecret: String,
        version: String
    ): Single<VenuesPhotoResponse> {

        return requests.getVenuePhotos(venueId, clientId, clientSecret, version)

    }

    override fun getVenues(
        clientId: String,
        clientSecret: String,
        version: String,
        limit: Int,
        location: String,
        radius: Int
    ): Single<VenuesResponse> {
        return requests.getVenues(clientId, clientSecret, version, limit, location, radius)
    }

}