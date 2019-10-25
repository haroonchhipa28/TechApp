package com.example.mohammadchhipa.techchallengeapp.di.module

import com.example.mohammadchhipa.techchallengeapp.api.ApiClient
import com.example.mohammadchhipa.techchallengeapp.model.WebServices
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
object NetworkModule {

//    @Provides
//    @Singleton
//    fun provideHttpClient(): OkHttpClient {
//        return OkHttpClient().newBuilder().build()
//    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiClient.BASE_URL)
                //converts Retrofit response into Observable
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
    }

    @Provides
    @Reusable
    @JvmStatic
    fun provideItemService(retrofit: Retrofit): WebServices {
        return retrofit.create<WebServices>(WebServices::class.java)
    }

//    @Provides
//    fun provideRepository(service: WebServices, database: AppDatabase): DataRepository {
//        return DataRepository(service, database)
//    }
}