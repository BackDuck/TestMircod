package com.example.testmircod.data.mappers

import com.example.testmircod.data.network.pojo.response.venuesphoto.PhotoItem

object VenuePhotoMapper {
    fun map(item: PhotoItem): String {
        return StringBuilder().append(item.prefix)
            .append(item.width)
            .append("x")
            .append(item.height)
            .append(item.suffix)
            .toString()
    }
}