package com.example.testmircod.data.network.pojo.response.venues

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class VenuesCategoryIcon (
    @field:SerializedName("prefix")
    @field:Expose
    var prefix: String = "",

    @field:SerializedName("suffix")
    @field:Expose
    var suffix: String = ""

)

