package com.example.mohammadchhipa.techchallengeapp.di.module

import android.app.Application
import android.content.Context
import com.example.mohammadchhipa.techchallengeapp.utils.NetworkUtils
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    internal fun provideNetworkUtils(context: Context): NetworkUtils {
        return NetworkUtils(context)
    }
}