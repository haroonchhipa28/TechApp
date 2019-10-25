package com.example.mohammadchhipa.techchallengeapp.database

import androidx.paging.DataSource
import androidx.room.*
import com.example.mohammadchhipa.techchallengeapp.model.DeliveryData

@Dao
interface DeliveriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(list: List<DeliveriesData>)

    @Query("select * from deliveries")
    fun getAll(): List<DeliveriesData>

    @Query("select * from deliveries")
    fun getAllPaged(): DataSource.Factory<Int, DeliveriesData>

    @Delete
    fun delete(deliveriesData: DeliveriesData)

}