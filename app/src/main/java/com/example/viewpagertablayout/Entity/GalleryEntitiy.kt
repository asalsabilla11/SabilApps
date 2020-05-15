package com.example.viewpagertablayout.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.viewpagertablayout.R

@Entity(tableName = "gallery")
data class GalleryEntitiy(
    @PrimaryKey
    val id: Int,
    val image: Int
){
    companion object{
        fun setDataGallery():ArrayList<GalleryEntitiy>{
            val list= ArrayList<GalleryEntitiy>()
            list.add(
                GalleryEntitiy(1, R.drawable.satu)
            )
            list.add(
                GalleryEntitiy(2, R.drawable.second)
            )
            list.add(
                GalleryEntitiy(3, R.drawable.three)
            )
            list.add(
                GalleryEntitiy(4, R.drawable.four)
            )
            return list
        }
    }
}