package com.example.testmircod.data.network.requests.general

import io.reactivex.Single
import com.example.testmircod.data.network.pojo.response.venues.VenuesResponse
import com.example.testmircod.data.network.pojo.response.venuesphoto.VenuesPhotoResponse
import com.example.testmircod.data.network.requests.ExceptionSingleComposer

class RequestExceptionWrapper(halvaRequests: Requests) : RequestsDecorator(halvaRequests) {


    override fun getVenuePhotos(
        venueId: String,
        clientId: String,
        clientSecret: String,
        version: String

    ): Single<VenuesPhotoResponse> {
        return super.getVenuePhotos(venueId, clientId, clientSecret, version).compose(
            ExceptionSingleComposer()
        )
    }

    override fun getVenues(
        clientId: String,
        clientSecret: String,
        version: String,
        limit: Int,
        location: String,
        radius: Int
    ): Single<VenuesResponse> {
        return super.getVenues(clientId, clientSecret, version, limit, location, radius).compose(
            ExceptionSingleComposer()
        )
    }

}