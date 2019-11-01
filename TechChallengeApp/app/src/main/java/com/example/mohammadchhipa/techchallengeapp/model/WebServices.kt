package com.example.mohammadchhipa.techchallengeapp.model

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WebServices {

//    @GET("deliveries")
//    fun getDeliveryData(): Single<List<DeliveryData>>

    @GET("deliveries")
    fun getDeliveryData(@Query("offset") offset: Int, @Query("limit") limit: Int)
            : Single<List<DeliveryDataResponse>>
}
