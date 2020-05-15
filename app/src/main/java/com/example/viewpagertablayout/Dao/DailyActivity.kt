package com.example.viewpagertablayout.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.viewpagertablayout.Entity.DailyAcitivtyEntity

@Dao
interface DailyActivity {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDataDaily(dailyEntity: List<DailyAcitivtyEntity>)

    @Query("select * from daily")
    fun getDataDaily(): List<DailyAcitivtyEntity>
}