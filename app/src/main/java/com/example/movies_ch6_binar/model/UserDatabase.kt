package com.example.movies_ch6_binar.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.movies_ch6_binar.dao.UserDao

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    abstract fun myUserDao() : UserDao
    companion object{
        @Volatile

        var INSTANCE : UserDatabase? = null

        fun getDatabaseInstance(context: Context): UserDatabase{
            val temInstance = INSTANCE
            if (temInstance != null ){
                return temInstance
            }
            synchronized(this){
                val roomDatabaseInstance = Room.databaseBuilder(context, UserDatabase::class.java, "User").allowMainThreadQueries().build()
                INSTANCE=roomDatabaseInstance
                return return roomDatabaseInstance
            }
        }
    }


}

