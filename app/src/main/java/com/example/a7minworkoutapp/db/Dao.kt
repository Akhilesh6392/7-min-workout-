package com.example.a7minworkoutapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.a7minworkoutapp.models.Dates

@Dao
interface Dao {



    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addData(dates: Dates)


    @Query("DELETE FROM dates_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM dates_table ORDER BY id ASC")
    fun readAllDates(): LiveData<List<Dates>>
}