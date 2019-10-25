package com.example.mohammadchhipa.techchallengeapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "deliveries")
data class DeliveriesData(
        @PrimaryKey
        val id: Int,
        var description: String,
        var imageUrl: String,
        var lat: Double,
        var lng: Double,
        var address: String
)

