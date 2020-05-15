package com.example.viewpagertablayout.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.viewpagertablayout.R

@Entity(tableName = "profile")
data class ProfileEntity(
    @PrimaryKey
    val id: Int,
    val image: Int,
    val nama: String,
    val desc: String,
    val contact: String,
    val email: String,
    val instagram: String
){
    companion object{
        fun setDataProfile(): ArrayList<ProfileEntity>{
            val list = ArrayList<ProfileEntity>()
            list.add(
                ProfileEntity(1, R.drawable.picture,"Annisa Salsabilla","I am a person who likes to learn something interesting to know. For example, about psychology or language. I like sports, traveling and hanging out with my friends. I also like to hear music with diverse genres, whether it's kpop, pop, jazz  as long as it's nice to hear.","0812564302","annisalsa27@gmail.com","asabilla11")
            )
            return list
        }
    }
}