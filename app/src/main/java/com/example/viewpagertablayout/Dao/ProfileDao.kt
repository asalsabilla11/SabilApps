package com.example.viewpagertablayout.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.viewpagertablayout.Entity.ProfileEntity

@Dao
interface ProfileDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDataProfile(profileEntity: List<ProfileEntity>)

    @Query("select * from profile")
    fun getDataProfile(): List<ProfileEntity>
}