package com.example.mohammadchhipa.techchallengeapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

//data class DeliveryData(val id: Int, val description: String, val imageUrl: String, val lat: Double, val lng: Double, val address: String)

@Entity(tableName = "deliveries")
data class DeliveryData(
        @PrimaryKey
        val id: Int,
        var description: String = "",
        var imageUrl: String = "",
        var lat: Double,
        var lng: Double,
        var address: String = ""
) : Serializable