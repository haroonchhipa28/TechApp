package com.example.mohammadchhipa.techchallengeapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mohammadchhipa.techchallengeapp.di.component.DaggerViewModelInjector
import com.example.mohammadchhipa.techchallengeapp.di.component.ViewModelInjector
import com.example.mohammadchhipa.techchallengeapp.di.module.NetworkModule

abstract class BaseViewModel : ViewModel() {

    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is MainViewModel -> injector.inject(this)
        }
    }


}