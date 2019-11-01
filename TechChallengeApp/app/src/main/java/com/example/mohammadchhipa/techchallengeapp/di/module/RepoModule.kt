package com.example.mohammadchhipa.techchallengeapp.di.module

import com.example.mohammadchhipa.techchallengeapp.data.DataMapper
import com.example.mohammadchhipa.techchallengeapp.database.DeliveriesDao
import com.example.mohammadchhipa.techchallengeapp.domain.datasource.BaseDataSource
import com.example.mohammadchhipa.techchallengeapp.domain.datasource.DeliveryDataSource
import com.example.mohammadchhipa.techchallengeapp.domain.repository.BaseRepo
import com.example.mohammadchhipa.techchallengeapp.domain.repository.DataRepo
import com.example.mohammadchhipa.techchallengeapp.model.DeliveryData
import com.example.mohammadchhipa.techchallengeapp.model.WebServices
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {

    @Provides
    @Singleton
    fun provideDataSource(
            dao: DeliveriesDao
    ): BaseDataSource<DeliveryData, Int> {
        return DeliveryDataSource(dao)
    }

    @Provides
    @Singleton
    fun provideRepository(service: WebServices,
                          deliveryDataSource: DeliveryDataSource,
                          mapper: DataMapper
    ): BaseRepo<DeliveryData, Int> {
        return DataRepo(service, deliveryDataSource, mapper)
    }
}