package com.example.mohammadchhipa.techchallengeapp.utils

import android.content.Context
import android.net.ConnectivityManager
import javax.inject.Inject

class NetworkUtils @Inject constructor(private val context: Context) {
    fun internetAvailability(): Boolean {
        val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        @Suppress("DEPRECATION", "RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
        return (connectivityManager.activeNetworkInfo == null ||
                !connectivityManager.activeNetworkInfo.isConnected).not()
    }

}