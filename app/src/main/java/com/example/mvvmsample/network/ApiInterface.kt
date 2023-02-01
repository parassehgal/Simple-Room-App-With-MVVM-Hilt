package com.example.mvvmsample.network

import com.example.mvvmsample.models.Medicine
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("api/medicines")
    suspend fun getMedicineList(): Response<Medicine>

}