package com.example.testmircod.data.mappers

import com.example.testmircod.data.network.pojo.response.venues.VenuesItem
import com.example.testmircod.domain.entity.VenueEntity

object VenueMapper {
    fun map(item: VenuesItem): VenueEntity {
        val address = StringBuilder()
        for(addressItem in item.location.formattedAddress){
            address.append(addressItem).append(" ")
        }

        val categoryIcon = StringBuilder().append(item.categories.first().icon.prefix)
            .append(64)
            .append(item.categories.first().icon.suffix)
            .toString()

        return VenueEntity(
            item.id,
            item.name,
            address.toString(),
            item.location.distance,
            item.categories.first().name,
            categoryIcon,
            item.location.postalCode,
             item.location.lat,
            item.location.lng
        )
    }
}