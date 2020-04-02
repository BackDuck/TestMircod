package com.example.testmircod.data.network.pojo.response.venues

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class VenuesItemLocation {
    @field:SerializedName("address")
    @field:Expose
    var address: String = ""

    @field:SerializedName("crossStreet")
    @field:Expose
    var crossStreet: String = ""

    @field:SerializedName("lat")
    @field:Expose
    var lat: Double = 0.0

    @field:SerializedName("lng")
    @field:Expose
    var lng: Double = 0.0

    @field:SerializedName("distance")
    @field:Expose
    var distance: Int = 0

    @field:SerializedName("postalCode")
    @field:Expose
    var postalCode: String = ""

    @field:SerializedName("cc")
    @field:Expose
    var cc: String = ""

    @field:SerializedName("city")
    @field:Expose
    var city: String = ""

    @field:SerializedName("state")
    @field:Expose
    var state: String = ""

    @field:SerializedName("country")
    @field:Expose
    var country: String = ""

    @field:SerializedName("formattedAddress")
    @field:Expose
    var formattedAddress: List<String> = emptyList()

}

