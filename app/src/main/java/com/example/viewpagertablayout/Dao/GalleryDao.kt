package com.example.viewpagertablayout.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.viewpagertablayout.Entity.GalleryEntitiy

@Dao
interface GalleryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDataDaily(dailyEntity: List<GalleryEntitiy>)

    @Query("select * from gallery")
    fun getDataDaily(): List<GalleryEntitiy>
}