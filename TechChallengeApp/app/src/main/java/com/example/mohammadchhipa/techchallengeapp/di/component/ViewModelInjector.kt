package com.example.mohammadchhipa.techchallengeapp.di.component

import com.example.mohammadchhipa.techchallengeapp.di.module.DatabaseModule
import com.example.mohammadchhipa.techchallengeapp.di.module.NetworkModule
import com.example.mohammadchhipa.techchallengeapp.viewmodel.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class])
interface ViewModelInjector {

//    fun inject(techApplication: TechApplication)
//
//    fun inject(dataRepository: DataRepository)

    fun inject(mainViewModel: MainViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector
        fun networkModule(networkModule: NetworkModule): Builder
    }
}