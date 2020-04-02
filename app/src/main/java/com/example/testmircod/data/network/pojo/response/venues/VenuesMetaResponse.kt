package com.example.testmircod.data.network.pojo.response.venues

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class VenuesMetaResponse {
    @field:SerializedName("code")
    @field:Expose
    var id: Int = 0

    @field:SerializedName("requestId")
    @field:Expose
    var requestId: String = ""

}

