package com.example.viewpagertablayout

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.viewpagertablayout.Dao.*
import com.example.viewpagertablayout.Entity.*


@Database(entities = [
    DailyAcitivtyEntity::class,
    GalleryEntitiy::class,
    FriendsListEntity::class,
    MusicEntity::class,
    ProfileEntity::class],version = 6)
abstract class DatabaseAku:RoomDatabase() {

    abstract fun dailyDao(): DailyActivity
    abstract fun galleryDao(): GalleryDao
    abstract fun friendsListDao(): FriendsListDao
    abstract fun musicDao(): MusicDao
    abstract fun profileDao(): ProfileDao

    companion object{
        @Volatile
        private var INSTANCE: DatabaseAku? = null

        fun getInstance(context: Context): DatabaseAku =
            INSTANCE?: synchronized(this){
                INSTANCE?: buildDatabase(context).also{INSTANCE = it}
            }

        private fun buildDatabase(context: Context)=
            Room.databaseBuilder(context.applicationContext,
                DatabaseAku::class.java,"databaseAku").fallbackToDestructiveMigration().build()
    }

}