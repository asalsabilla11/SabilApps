package com.example.viewpagertablayout.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "daily")
data class DailyAcitivtyEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val waktu: String
){
    companion object{
        fun setDataDaily():ArrayList<DailyAcitivtyEntity>{
            val list= ArrayList<DailyAcitivtyEntity>()
            list.add(
                DailyAcitivtyEntity(1, "Wake up and Pray","05:15 PM")
            )
            list.add(
                DailyAcitivtyEntity(2, "Bath","06:00 AM")
            )
            list.add(
                DailyAcitivtyEntity(3, "Study","07:00 AM")
            )
            list.add(
                DailyAcitivtyEntity(4, "Brunch","10:00 AM")
            )
            list.add(
                DailyAcitivtyEntity(5, "Pray zuhur","13:15 PM")
            )
            list.add(
                DailyAcitivtyEntity(6, "Pray Ashar","15:30 PM")
            )
            list.add(
                DailyAcitivtyEntity(7, "Playing basketball","16:00 PM")
            )
            list.add(
                DailyAcitivtyEntity(8, "Maghrib","18:15 PM")
            )
            list.add(
                DailyAcitivtyEntity(9, "Bath and Dinner","19:00 PM")
            )
            list.add(
                DailyAcitivtyEntity(10, "Isya","20:00 PM")
            )
            list.add(
                DailyAcitivtyEntity(11, "Sleep","23:00 PM")
            )

            return list
        }
    }
}