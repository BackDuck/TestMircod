package com.example.testmircod.data.network.pojo.response.venuesphoto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class VenuesPhotoBody (
    @field:SerializedName("photos")
    @field:Expose
    var photosList: PhotosWrapper

)

