package com.example.mohammadchhipa.techchallengeapp.database

import androidx.paging.DataSource
import androidx.room.*
import com.example.mohammadchhipa.techchallengeapp.model.DeliveryData
import io.reactivex.Single

@Dao
interface DeliveriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItem(deliveryData: DeliveryData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(list: List<DeliveryData>)

    @Query("select * from deliveries")
    fun getAll(): DataSource.Factory<Int, DeliveryData>

    @Query("select * from deliveries")
    fun getAllPaged(): DataSource.Factory<Int, DeliveryData>

    @Query("DELETE FROM deliveries")
    fun deleteAll()

    @Query("DELETE FROM deliveries WHERE id= :id")
    fun deleteData(id: Int)

    @Query("SELECT count(*) FROM deliveries")
    fun getCount(): Single<Int>

    @Query("SELECT * FROM deliveries WHERE id= :id")
    fun getDeliveryItem(id: Int): Single<DeliveryData>

}