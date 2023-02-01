package com.example.mvvmsample.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mvvmsample.models.Medicine
import com.example.mvvmsample.models.MedicineItem

@Dao
interface MedicineDao {

    @Query("SELECT * FROM medicineitem")
    suspend fun getMedicine(): List<MedicineItem>

    @Insert
    suspend fun insertMedicine(medicine: MutableList<MedicineItem>)

}