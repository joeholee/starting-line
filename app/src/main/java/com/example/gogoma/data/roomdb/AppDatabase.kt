package com.example.newroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gogoma.data.roomdb.entity.Friend
import com.example.gogoma.data.roomdb.entity.Marathon
import com.example.gogoma.data.roomdb.entity.MyInfo
import com.example.newroom.dao.FriendDao
import com.example.newroom.dao.MarathonDao
import com.example.newroom.dao.MyInfoDao

@Database(entities = [MyInfo::class, Friend::class, Marathon::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun myInfoDao(): MyInfoDao
    abstract fun friendDao(): FriendDao
    abstract fun marathonDao(): MarathonDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase{
            return INSTANCE ?: synchronized(this){
                INSTANCE ?: Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "database"
                        ).build()
            }
        }
    }
}
