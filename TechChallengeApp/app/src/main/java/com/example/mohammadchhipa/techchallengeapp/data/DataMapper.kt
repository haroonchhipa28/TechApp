package com.example.mohammadchhipa.techchallengeapp.data

import com.example.mohammadchhipa.techchallengeapp.model.DeliveryData
import com.example.mohammadchhipa.techchallengeapp.model.DeliveryDataResponse
import javax.inject.Inject

class DataMapper @Inject constructor() {

    fun map(responseList: List<DeliveryDataResponse>): List<DeliveryData> {
        return responseList.map { (map(it)) }
    }

    private fun map(response: DeliveryDataResponse): DeliveryData {
        return DeliveryData(
                id = response.id,
                imageUrl = response.imageUrl,
                description = response.description,
                lat = response.location.lat,
                lng = response.location.lng,
                address = response.location.address)
    }
}