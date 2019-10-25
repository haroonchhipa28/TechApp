package com.example.mohammadchhipa.techchallengeapp.database

import com.example.mohammadchhipa.techchallengeapp.model.WebServices
import io.reactivex.Observable
import javax.inject.Inject


class DataRepository(service1: WebServices, database1: AppDatabase) {

    private var service = service1
    private var database = database1

    @Inject
    fun DataRepository(service: WebServices) {
        this.service = service
    }

    fun getDeliveryData(): Observable<ArrayList<com.example.mohammadchhipa.techchallengeapp.model.DeliveryData>> {
        return service.getDeliveryData()
    }

//    fun insertData(data: List<DeliveriesData>) {
//        database.deliveriesDao().insertData(data)
//    }

}