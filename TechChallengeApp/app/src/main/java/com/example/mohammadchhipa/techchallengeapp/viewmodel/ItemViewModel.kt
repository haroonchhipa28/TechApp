package com.example.mohammadchhipa.techchallengeapp.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.mohammadchhipa.techchallengeapp.model.DeliveryData
import com.example.mohammadchhipa.techchallengeapp.view.BaseViewModel
import javax.inject.Inject

class ItemViewModel @Inject constructor() : BaseViewModel() {

    private val deliveryId = MutableLiveData<Int>()

    val description = MutableLiveData<String>()
    val imageUrl = MutableLiveData<String>()

    fun bind(deliveryData: DeliveryData) {
        description.value = deliveryData.description
        imageUrl.value = deliveryData.imageUrl
    }
}