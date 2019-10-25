package com.example.mohammadchhipa.techchallengeapp

import android.app.Application
import com.example.mohammadchhipa.techchallengeapp.di.component.ViewModelInjector
import com.example.mohammadchhipa.techchallengeapp.di.module.NetworkModule


class TechApplication : Application() {
    companion object {
        lateinit var app: TechApplication
        lateinit var dataComponent: ViewModelInjector
    }

    override fun onCreate() {
        super.onCreate()
//        app = this
//        initDataComponent()
//        dataComponent.inject(this)
    }

    private fun initDataComponent() {
//        dataComponent = DaggerDataComponent.builder()
//                .dataModule(NetworkModule(this))
//                .build();
    }

    fun getApp(): TechApplication {
        return app
    }

    fun getDataComponent(): ViewModelInjector {
        return dataComponent
    }
}