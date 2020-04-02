package com.example.testmircod.data.network.pojo.response.venuesphoto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PhotoItem (
    @field:SerializedName("prefix")
    @field:Expose
    var prefix: String = "",

    @field:SerializedName("suffix")
    @field:Expose
    var suffix: String = "",

    @field:SerializedName("width")
    @field:Expose
    var width: Int,

    @field:SerializedName("height")
    @field:Expose
    var height: Int
)

