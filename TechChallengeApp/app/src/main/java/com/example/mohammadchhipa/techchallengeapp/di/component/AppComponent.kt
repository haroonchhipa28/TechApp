package com.example.mohammadchhipa.techchallengeapp.di.component

import android.app.Application
import com.example.mohammadchhipa.techchallengeapp.TechApplication
import com.example.mohammadchhipa.techchallengeapp.di.builder.ActivityBuilder
import com.example.mohammadchhipa.techchallengeapp.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [AndroidInjectionModule::class, AndroidSupportInjectionModule::class,
            AppModule::class, ViewModelModule::class,
            ActivityBuilder::class,
            DatabaseModule::class, RepoModule::class,
            NetworkModule::class])

interface AppComponent {

    fun inject(app: TechApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}