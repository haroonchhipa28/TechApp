package com.example.mohammadchhipa.techchallengeapp.domain.datasource

import androidx.paging.DataSource
import io.reactivex.Single


interface BaseDataSource<T, K> {

    fun getEntities(): DataSource.Factory<K, T>

    fun saveEntityList(list: List<T>)

    fun saveEntity(entity: T)

    fun updateEntity(entity: T)

    fun deleteEntity(entity: T)

    fun deleteAll()

    fun getById(id: K): Single<T>

    fun count(): Single<Int>
}