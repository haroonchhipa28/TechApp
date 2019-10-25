package com.example.mohammadchhipa.techchallengeapp.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.mohammadchhipa.techchallengeapp.database.AppDatabase
import com.example.mohammadchhipa.techchallengeapp.viewmodel.MainViewModel
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val activity: AppCompatActivity) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            val db = Room.databaseBuilder(activity.applicationContext, AppDatabase::class.java, AppDatabase.DB_NAME).build()
            return MainViewModel(db.deliveriesDao()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}