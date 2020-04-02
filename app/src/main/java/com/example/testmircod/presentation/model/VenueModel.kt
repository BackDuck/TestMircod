package com.example.testmircod.presentation.model

import com.example.testmircod.domain.entity.VenueEntity
import java.io.Serializable


data class VenueModel(
    val id: String,
    val name: String,
    val distance: Int,
    val address: String,
    val postcode: String,
    val category: String,
    val categoryIcon: String,
    val photos: List<String>,
    val lat: Double,
    val lon: Double
): Serializable

object VenueModelMapper {
    fun map(item: Pair<VenueEntity, List<String>>): VenueModel {
        return item.run {
            VenueModel(
                this.first.id,
                this.first.name,
                this.first.distance,
                this.first.address,
                this.first.postalCode,
                this.first.category,
                this.first.categoryIcon,
                this.second,
                this.first.lat,
                this.first.lon)
        }
    }
}