package com.example.mohammadchhipa.techchallengeapp.domain.usecases

import androidx.paging.DataSource
import com.example.mohammadchhipa.techchallengeapp.data.Result
import io.reactivex.Observable
import io.reactivex.Single

interface BaseUseCases<T, K> {

    fun fetchItemList(offset: Int, limit: Int): Observable<Result>

    fun getItemList(): DataSource.Factory<K, T>

    fun getSingleItem(id: K): Single<T>

    fun getCount(): Single<Int>

    fun removeAll()
}