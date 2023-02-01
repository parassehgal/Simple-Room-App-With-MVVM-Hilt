package com.example.mvvmsample.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvmsample.models.MedicineItem
import com.example.mvvmsample.room.dao.MedicineDao

@Database(entities = [MedicineItem::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun medicineDao(): MedicineDao

}