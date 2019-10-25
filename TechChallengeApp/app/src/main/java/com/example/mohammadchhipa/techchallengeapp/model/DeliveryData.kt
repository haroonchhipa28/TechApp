package com.example.mohammadchhipa.techchallengeapp.model

import com.example.mohammadchhipa.techchallengeapp.database.DeliveriesData
import com.squareup.moshi.JsonClass

data class DeliveryData(val id: Int, val description: String, val imageUrl: String, val location: Location)

data class Location(val lat: Double, val lng: Double, val address: String)

fun List<DeliveryData>.asDbModel(): List<DeliveriesData> {
    return map {
        DeliveriesData(id = it.id, description = it.description, imageUrl = it.imageUrl
                , lat = it.location.lat, lng = it.location.lng, address = it.location.address)
    }
}