package com.example.mohammadchhipa.techchallengeapp.domain.usecases

import androidx.paging.DataSource
import com.example.mohammadchhipa.techchallengeapp.data.Result
import com.example.mohammadchhipa.techchallengeapp.domain.repository.BaseRepo
import com.example.mohammadchhipa.techchallengeapp.model.DeliveryData
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class DataUseCase @Inject constructor(private val repo: BaseRepo<DeliveryData, Int>) :
        BaseUseCases<DeliveryData, Int> {

    override fun fetchItemList(offset: Int, limit: Int): Observable<Result> {
        return repo.get(offset, limit).toObservable()
                .map { Result.Success(it) as Result }
                .onErrorReturn { Result.Failure(it) }
                .startWith(Result.Loading)
    }

    override fun getItemList(): DataSource.Factory<Int, DeliveryData> {
        return repo.get()
    }

    override fun getSingleItem(id: Int): Single<DeliveryData> {
        return repo.getById(id)
    }


    override fun getCount(): Single<Int> {
        return repo.count()
    }

    override fun removeAll() {
        repo.deleteAll()
    }

}