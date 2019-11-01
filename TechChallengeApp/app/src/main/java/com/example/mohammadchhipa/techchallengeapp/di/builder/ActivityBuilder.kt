package com.example.mohammadchhipa.techchallengeapp.di.builder

import com.example.mohammadchhipa.techchallengeapp.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): MainActivity

}