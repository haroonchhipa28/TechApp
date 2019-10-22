package com.example.mohammadchhipa.techchallengeapp.database

import android.database.Observable
import com.example.mohammadchhipa.techchallengeapp.model.WebServices
import javax.inject.Inject


class DataRepository {

    lateinit var service: WebServices

    @Inject
    fun DataRepository(service: WebServices) {
        this.service = service
    }

    fun getDeliveryData(): Observable<DeliveryData> {
        return service.getDeliveryData()
    }
}