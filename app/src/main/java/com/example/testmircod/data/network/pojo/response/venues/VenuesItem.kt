package com.example.testmircod.data.network.pojo.response.venues

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class VenuesItem (
    @field:SerializedName("id")
    @field:Expose
    var id: String = "",

    @field:SerializedName("name")
    @field:Expose
    var name: String = "",

    @field:SerializedName("location")
    @field:Expose
    var location: VenuesItemLocation,

    @field:SerializedName("categories")
    @field:Expose
    var categories: List<VenuesCategory>

)

