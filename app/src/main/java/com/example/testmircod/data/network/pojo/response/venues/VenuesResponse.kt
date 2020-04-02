package com.example.testmircod.data.network.pojo.response.venues

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
data class VenuesResponse (

    @field:SerializedName("response")
    @field:Expose
    var response: VenuesResponseBody
)
