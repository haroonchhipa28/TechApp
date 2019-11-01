package com.example.mohammadchhipa.techchallengeapp.domain.repository

import androidx.paging.DataSource
import com.example.mohammadchhipa.techchallengeapp.data.DataMapper
import com.example.mohammadchhipa.techchallengeapp.domain.datasource.BaseDataSource
import com.example.mohammadchhipa.techchallengeapp.model.DeliveryData
import com.example.mohammadchhipa.techchallengeapp.model.WebServices
import io.reactivex.Single


class DataRepo constructor(private val service: WebServices,
                           private val dataSource: BaseDataSource<DeliveryData, Int>,
                           private val mapper: DataMapper
) : BaseRepo<DeliveryData, Int> {

    override fun get(offset: Int, limit: Int): Single<List<DeliveryData>> {
        return service.getDeliveryData(offset, limit)
                .map {
                    val list: List<DeliveryData> = mapper.map(it)
                    if (offset == 0) {
                        dataSource.deleteAll()
                    }
                    dataSource.saveEntityList(list)
                    return@map list
                }
    }

    override fun get(): DataSource.Factory<Int, DeliveryData> {
        return dataSource.getEntities()
    }

    override fun getById(id: Int): Single<DeliveryData> {
        return dataSource.getById(id)
    }

    override fun deleteAll() {
        dataSource.deleteAll()
    }

    override fun count(): Single<Int> {
        return dataSource.count()
    }

    override fun save(entity: DeliveryData) {
        dataSource.saveEntity(entity)
    }

    override fun save(list: List<DeliveryData>) {
        dataSource.saveEntityList(list)
    }

    override fun update(entity: DeliveryData) {
        dataSource.updateEntity(entity)
    }

    override fun delete(entity: DeliveryData) {
        dataSource.deleteEntity(entity)
    }

}
