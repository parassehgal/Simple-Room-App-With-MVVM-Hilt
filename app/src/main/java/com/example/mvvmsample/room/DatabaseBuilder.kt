package com.example.mvvmsample.room

import android.content.Context
import androidx.room.Room
import com.example.mvvmsample.app.MainApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseBuilder {

    @Provides
    @Singleton
    @Synchronized fun getInstance(): AppDatabase {
        return buildRoomDB(MainApp.appContext)
    }

    private fun buildRoomDB(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "paras-example-coroutines"
        ).build()

    @Provides
    fun getDao(appDatabase: AppDatabase) = appDatabase.medicineDao()

}