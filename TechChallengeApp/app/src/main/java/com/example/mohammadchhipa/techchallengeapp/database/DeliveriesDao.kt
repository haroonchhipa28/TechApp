package com.example.mohammadchhipa.techchallengeapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DeliveriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveData(list: List<DeliveryData>)

    @Query("select * from deliveries")
    fun getAll(): LiveData<List<DeliveryData>>

}