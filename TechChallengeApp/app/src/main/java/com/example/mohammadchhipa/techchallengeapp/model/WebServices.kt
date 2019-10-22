package com.example.mohammadchhipa.techchallengeapp.model


import android.database.Observable
import com.example.mohammadchhipa.techchallengeapp.database.DeliveryData
import retrofit2.http.GET

interface WebServices {

    @GET("deliveries")
    fun getDeliveryData(): Observable<DeliveryData>

}
