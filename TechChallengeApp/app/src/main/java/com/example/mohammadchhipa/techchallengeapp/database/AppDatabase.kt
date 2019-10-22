package com.example.mohammadchhipa.techchallengeapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DeliveryData::class], version = AppDatabase.VERSION)
abstract class AppDatabase : RoomDatabase() {

    abstract fun deliveriesDao(): DeliveriesDao

    companion object {
        const val DB_NAME = "deliveries.db"
        const val VERSION = 1
    }
}