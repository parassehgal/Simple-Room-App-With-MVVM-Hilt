package com.example.mvvmsample.di

import com.example.mvvmsample.repositories.MedicineRepository
import com.example.mvvmsample.repositories.MedicineRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideMedicineRepository(medicineRepositoryImpl: MedicineRepositoryImpl): MedicineRepository

}