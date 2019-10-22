package com.example.mohammadchhipa.techchallengeapp.di.module

import android.app.Application
import com.example.mohammadchhipa.techchallengeapp.api.ApiClient
import com.example.mohammadchhipa.techchallengeapp.model.WebServices
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient

@Module
class DataModule {
    lateinit var application: Application

    fun DataModule(application: Application) {
        this.application = application
    }

    @Provides
    fun provideItemService(retrofit: Retrofit): WebServices {
        return retrofit.create<WebServices>(WebServices::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiClient.BASE_URL)
                .client(okHttpClient)
                //converts Retrofit response into Observable
                //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder().build()
    }

}