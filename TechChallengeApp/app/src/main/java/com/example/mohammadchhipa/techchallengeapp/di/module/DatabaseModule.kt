package com.example.mohammadchhipa.techchallengeapp.di.module

import android.app.Application
import androidx.room.Room
import com.example.mohammadchhipa.techchallengeapp.database.AppDatabase
import com.example.mohammadchhipa.techchallengeapp.database.DeliveriesDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import kotlin.jvm.java

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(application: Application): AppDatabase {
        return Room
                .databaseBuilder(application, AppDatabase::class.java, AppDatabase.DB_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }

    @Provides
    fun provideDeliveryDao(appDatabase: AppDatabase): DeliveriesDao {
        return appDatabase.deliveriesDao()
    }
}