package com.example.testmircod.data.network.pojo.response.venues

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class VenuesCategory (
    @field:SerializedName("id")
    @field:Expose
    var id: String = "",

    @field:SerializedName("name")
    @field:Expose
    var name: String = "",

    @field:SerializedName("icon")
    @field:Expose
    var icon: VenuesCategoryIcon,

    @field:SerializedName("primary")
    @field:Expose
    var primary: Boolean

)

