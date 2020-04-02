package com.example.testmircod.data.network.pojo.response.venues

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class VenuesResponseBody (
    @field:SerializedName("venues")
    @field:Expose
    var venuesList: List<VenuesItem>

)

