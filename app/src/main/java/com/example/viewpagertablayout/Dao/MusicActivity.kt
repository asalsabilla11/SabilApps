package com.example.viewpagertablayout.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.viewpagertablayout.Entity.MusicEntity

@Dao
interface MusicActivity {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDataMusic(musicEntity: List<MusicEntity>)

    @Query("select * from music")
    fun getDataMusic(): List<MusicEntity>
}