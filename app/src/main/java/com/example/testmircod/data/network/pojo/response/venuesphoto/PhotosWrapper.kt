package com.example.testmircod.data.network.pojo.response.venuesphoto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PhotosWrapper(
    @field:SerializedName("count")
    @field:Expose
    var count: Int,

    @field:SerializedName("items")
    @field:Expose
    var items: List<PhotoItem>

)

