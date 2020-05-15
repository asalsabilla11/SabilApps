package com.example.viewpagertablayout.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.viewpagertablayout.Entity.FriendsListEntity


@Dao
interface FriendsListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setFriendsList(friendsList: List<FriendsListEntity>)

    @Query("select * from freindsList")
    fun getFriendsList(): List<FriendsListEntity>
}