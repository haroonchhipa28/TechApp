package com.example.mohammadchhipa.techchallengeapp.model

import io.reactivex.Observable
import retrofit2.http.GET

interface WebServices {

    @GET("deliveries")
    fun getDeliveryData(): Observable<ArrayList<DeliveryData>>

//    @GET("deliveries")
//    fun getDeliveryData(@Query("offset") offset: Int, @Query("limit") limit: Int)
//            : Observable<ArrayList<DeliveriesData>>

}
