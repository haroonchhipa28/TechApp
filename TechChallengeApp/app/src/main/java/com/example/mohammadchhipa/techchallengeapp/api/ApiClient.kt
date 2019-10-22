package com.example.mohammadchhipa.techchallengeapp.api

import com.example.mohammadchhipa.techchallengeapp.model.WebServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    var BASE_URL: String = "https://mock-api-mobile.dev.lalamove.com/"

//    companion object {
//        fun create(): WebServices {
//
//            val retrofit = Retrofit.Builder()
//                    .addConverterFactory(
//                            GsonConverterFactory.create())
//                    .baseUrl("https://en.wikipedia.org/w/")
//                    .build()
//
//            return retrofit.create(WebServices::class.java)
//        }
//    }

}