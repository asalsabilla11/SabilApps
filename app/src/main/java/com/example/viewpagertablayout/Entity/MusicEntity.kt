package com.example.viewpagertablayout.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "music")
data class MusicEntity(
    @PrimaryKey
    val id: Int,
    val penyanyi: String,
    val judulLagu: String
){
    companion object{
        fun setDataMusic(): ArrayList<MusicEntity>{
            val list = ArrayList<MusicEntity>()
            list.add(
                MusicEntity(1,"Billie Eilish","Everything I Wanted")
            )
            list.add(
                MusicEntity(2,"Pamungkas","One Only")
            )
            return list
        }
    }
}