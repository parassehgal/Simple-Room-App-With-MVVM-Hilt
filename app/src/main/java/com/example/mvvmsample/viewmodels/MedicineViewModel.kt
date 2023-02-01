package com.example.mvvmsample.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mvvmsample.models.MedicineItem
import com.example.mvvmsample.repositories.MedicineRepository
import com.example.mvvmsample.utils.LoadingStatusType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MedicineViewModel @Inject constructor(private var medicineRepository: MedicineRepository): BaseViewModel() {

    val medicineLiveData by lazy { MutableLiveData<List<MedicineItem>>() }

    fun getMedicineList() {
        viewModelScope.launch(coroutineExceptionHandler) {
            loadingStatusLiveData.postValue(LoadingStatusType.Loading())

            val medicineFromDb = medicineRepository.getMedicines()
            if (medicineFromDb.isEmpty()) {
                val medicinesFromApi = medicineRepository.getMedicineList()
                val medicinesToInsertInDB = mutableListOf<MedicineItem>()

                if (medicinesFromApi.isSuccessful) {
                    for (medicine in medicinesFromApi.body()!!) {
                        val medicineItem = MedicineItem(
                            company = medicine.company,
                            id = medicine.id,
                            name = medicine.name,
                            packform = medicine.packform,
                            strength = medicine.strength,
                            strengthtype = medicine.strengthtype,
                            type = medicine.type
                        )
                        medicinesToInsertInDB.add(medicineItem)
                        medicineLiveData.postValue(medicinesToInsertInDB)
                    }
                }
            } else {
                medicineLiveData.postValue(medicineFromDb)
            }
            loadingStatusLiveData.postValue(LoadingStatusType.Loaded())
        }
    }

}