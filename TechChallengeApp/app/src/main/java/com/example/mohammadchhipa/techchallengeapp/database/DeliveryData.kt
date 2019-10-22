package com.example.mohammadchhipa.techchallengeapp.database

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "deliveries")
data class DeliveryData(
        @PrimaryKey val id: String,
         var description: String,
         var imageUrl: String) {

}

