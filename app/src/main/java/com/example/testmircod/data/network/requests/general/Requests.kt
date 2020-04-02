package com.example.testmircod.data.network.requests.general

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import com.example.testmircod.data.network.pojo.response.venues.VenuesResponse
import com.example.testmircod.data.network.pojo.response.venuesphoto.VenuesPhotoResponse


interface Requests {
    @GET("venues/{venue_id}/photos")
    fun getVenuePhotos(@Path("venue_id") venueId: String,
                       @Query("client_id") clientId: String,
                       @Query("client_secret") clientSecret: String,
                       @Query("v") version: String
    ): Single<VenuesPhotoResponse>

    @GET("venues/search")
    fun getVenues(@Query("client_id") clientId: String,
                    @Query("client_secret") clientSecret: String,
                    @Query("v") version: String,
                    @Query("limit") limit: Int,
                    @Query("ll") location: String,
                    @Query("radius") radius: Int
    ): Single<VenuesResponse>


}