package com.example.movies_ch6_binar.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.movies_ch6_binar.dao.UserDao

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var userDatabase: UserDatabase? = null

        fun getData(context: Context): UserDatabase {
            return userDatabase?: synchronized(this){
                val data = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "Data.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                userDatabase = data
                data
            }
        }
    }
}

