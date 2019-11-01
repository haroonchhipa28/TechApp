package com.example.mohammadchhipa.techchallengeapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mohammadchhipa.techchallengeapp.model.DeliveryData

@Database(entities = [DeliveryData::class], version = AppDatabase.VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun deliveriesDao(): DeliveriesDao

    companion object {
        const val DB_NAME = "deliveries.db"
        const val VERSION = 1
    }
}