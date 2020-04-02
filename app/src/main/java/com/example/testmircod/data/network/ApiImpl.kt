package com.example.testmircod.data.network

import io.reactivex.Single
import com.example.testmircod.data.network.pojo.response.venues.VenuesResponse
import com.example.testmircod.data.network.pojo.response.venuesphoto.VenuesPhotoResponse
import com.example.testmircod.data.network.requests.general.Requests

class ApiImpl(
    private val requests: Requests
) : Api {
    val CLIENT_ID = "3NVC3S5QVOKUETMDF3RPRS0V3UH4KFWL3EHG3WP1AIVL123F"
    val CLIENT_SECRET = "0LDFHVF4RA3NDHXJTRFIUJQZZWW1QFTXEIKDTBXCIF15R2L0"
    val VERSION = "20180323"

    override fun getVenues(limit: Int, location: String, radius: Int): Single<VenuesResponse> {
        return requests.getVenues(CLIENT_ID, CLIENT_SECRET, VERSION, limit, location, radius)
    }

    override fun getVenuePhotos(venueId: String): Single<VenuesPhotoResponse> {
        return requests.getVenuePhotos(venueId, CLIENT_ID, CLIENT_SECRET, VERSION)
    }


}