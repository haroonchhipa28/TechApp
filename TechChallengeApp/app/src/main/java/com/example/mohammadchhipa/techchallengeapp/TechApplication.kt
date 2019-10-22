package com.example.mohammadchhipa.techchallengeapp

import android.app.Application
import com.example.mohammadchhipa.techchallengeapp.di.component.DataComponent
import com.example.mohammadchhipa.techchallengeapp.di.module.DataModule


class TechApplication : Application() {

    private lateinit var app: TechApplication

    private lateinit var dataComponent: DataComponent

    override fun onCreate() {
        super.onCreate()
        app = this
        initDataComponent()
        dataComponent.inject(this)
    }

    private fun initDataComponent() {
//        dataComponent = DaggerDataComponent.builder()
//                .dataModule(DataModule(this))
//                .build();
    }

    fun getApp(): TechApplication {
        return app
    }

    fun getDataComponent(): DataComponent {
        return dataComponent
    }
}