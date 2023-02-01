package com.example.mvvmsample.repositories

import com.example.mvvmsample.models.Medicine
import com.example.mvvmsample.models.MedicineItem
import com.example.mvvmsample.network.ApiInterface
import com.example.mvvmsample.room.dao.MedicineDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

/**
 * Medicine repository
 */
class MedicineRepositoryImpl @Inject constructor(private val mApi: ApiInterface, private val dispatcher: CoroutineDispatcher, private val medicineDao: MedicineDao): MedicineRepository {

    /**
     * Method to get medicines from API call
     */
    override suspend fun getMedicineList() = withContext(dispatcher) {
        mApi.getMedicineList()
    }

    /**
     * Method to get medicine list from database
     */
    override suspend fun getMedicines(): List<MedicineItem> {
        return medicineDao.getMedicine()
    }

    /**
     * Method to insert the complete medicine list
     */
    override suspend fun insertAll(medicineList: MutableList<MedicineItem>) {
        return medicineDao.insertMedicine(medicineList)
    }

}