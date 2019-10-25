package com.example.mohammadchhipa.techchallengeapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.mohammadchhipa.techchallengeapp.model.DeliveryData

class ItemViewModel : BaseViewModel() {
    private val description = MutableLiveData<String>()
    private val imageUrl = MutableLiveData<String>()

    fun bind(deliveryData: DeliveryData) {
        description.value = deliveryData.description
        imageUrl.value = deliveryData.imageUrl
    }

    fun getDescription(): MutableLiveData<String> {
        return description
    }

    fun getImageUrl(): MutableLiveData<String> {
        Log.d("image", imageUrl.value)
        return imageUrl
    }
}