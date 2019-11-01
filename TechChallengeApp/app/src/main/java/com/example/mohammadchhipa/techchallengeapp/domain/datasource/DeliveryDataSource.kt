package com.example.mohammadchhipa.techchallengeapp.domain.datasource

import androidx.paging.DataSource
import com.example.mohammadchhipa.techchallengeapp.database.DeliveriesDao
import com.example.mohammadchhipa.techchallengeapp.model.DeliveryData
import io.reactivex.Single
import javax.inject.Inject

class DeliveryDataSource @Inject constructor(private val dao: DeliveriesDao) : BaseDataSource<DeliveryData, Int> {

    override fun getEntities(): DataSource.Factory<Int, DeliveryData> {
        return dao.getAll()
    }


    override fun saveEntityList(list: List<DeliveryData>) {
        dao.insertData(list)
    }

    override fun deleteAll() {
        dao.deleteAll()
    }

    override fun getById(id: Int): Single<DeliveryData> {
        return dao.getDeliveryItem(id)
    }

    override fun count(): Single<Int> {
        return dao.getCount()
    }

    override fun saveEntity(entity: DeliveryData) {
        dao.insertItem(entity)
    }

    override fun updateEntity(entity: DeliveryData) {
        dao.insertItem(entity)
    }

    override fun deleteEntity(entity: DeliveryData) {
        dao.deleteData(entity.id)
    }

}