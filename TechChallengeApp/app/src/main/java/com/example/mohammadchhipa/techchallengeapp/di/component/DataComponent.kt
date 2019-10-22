package com.example.mohammadchhipa.techchallengeapp.di.component

import com.example.mohammadchhipa.techchallengeapp.TechApplication
import com.example.mohammadchhipa.techchallengeapp.database.DataRepository
import com.example.mohammadchhipa.techchallengeapp.di.module.DataModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(DataModule::class))

interface DataComponent {

    fun inject(retroRecyclerApplication: TechApplication)

    fun inject(dataRepository: DataRepository)


}