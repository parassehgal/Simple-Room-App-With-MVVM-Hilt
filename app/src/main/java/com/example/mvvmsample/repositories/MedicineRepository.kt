package com.example.mvvmsample.repositories

import com.example.mvvmsample.models.Medicine
import com.example.mvvmsample.models.MedicineItem
import retrofit2.Response

interface MedicineRepository {

    suspend fun getMedicineList(): Response<Medicine>

    suspend fun getMedicines(): List<MedicineItem>

    suspend fun insertAll(medicineList: MutableList<MedicineItem>)
}