package com.example.mohammadchhipa.techchallengeapp.di.module


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mohammadchhipa.techchallengeapp.di.ViewModelFactory
import com.example.mohammadchhipa.techchallengeapp.viewmodel.ItemViewModel
import com.example.mohammadchhipa.techchallengeapp.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ItemViewModel::class)
    internal abstract fun bindItemViewModel(viewModel: ItemViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}