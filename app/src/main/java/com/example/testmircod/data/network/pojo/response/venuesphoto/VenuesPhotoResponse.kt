package com.example.testmircod.data.network.pojo.response.venuesphoto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
data class VenuesPhotoResponse (

    @field:SerializedName("response")
    @field:Expose
    var response: VenuesPhotoBody
)
