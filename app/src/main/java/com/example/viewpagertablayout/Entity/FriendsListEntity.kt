package com.example.viewpagertablayout.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.viewpagertablayout.R

@Entity(tableName = "freindsList")
data class FriendsListEntity(
    @PrimaryKey
    val id: Int,
    val nama: String,
    val image: Int
){
    companion object{
        fun setFriendsData(): ArrayList<FriendsListEntity>{
            val list =  ArrayList<FriendsListEntity>()
            list.add(
                FriendsListEntity(1,"Shawn Mendes", R.drawable.shawn)
            )
            list.add(
                FriendsListEntity(2,"Lalisa Manoban", R.drawable.lisa)
            )
            list.add(
                FriendsListEntity(3,"Kendal Jenner", R.drawable.kendal)
            )
            return list
        }
    }
}