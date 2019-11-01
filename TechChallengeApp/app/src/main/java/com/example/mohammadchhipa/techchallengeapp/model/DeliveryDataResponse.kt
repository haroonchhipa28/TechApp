package com.example.mohammadchhipa.techchallengeapp.model

data class DeliveryDataResponse(
        val id: Int,
        var description: String = "",
        var imageUrl: String = "",
        var location: Location
)

data class Location(
        var lat: Double,
        var lng: Double,
        var address: String = ""
)