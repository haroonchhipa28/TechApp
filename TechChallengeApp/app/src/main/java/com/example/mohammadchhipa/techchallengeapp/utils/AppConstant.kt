package com.example.mohammadchhipa.techchallengeapp.utils

import com.example.mohammadchhipa.techchallengeapp.BuildConfig
import okhttp3.logging.HttpLoggingInterceptor

class AppConstant {
    object Const {
        val PAGE_SIZE = 20

        val sHTTP_LOG_LEVEL = if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
    }

    companion object {

        val DATA: String = "data"
    }

}

