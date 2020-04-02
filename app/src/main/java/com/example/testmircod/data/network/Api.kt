package com.example.testmircod.data.network

import io.reactivex.Single
import com.example.testmircod.data.network.pojo.response.venues.VenuesResponse
import com.example.testmircod.data.network.pojo.response.venuesphoto.VenuesPhotoResponse

interface Api {
    fun getVenues(limit: Int, location: String, radius: Int): Single<VenuesResponse>

    fun getVenuePhotos(venueId: String): Single<VenuesPhotoResponse>
}