package com.example.movies_ch6_binar.dao

import androidx.room.*
import com.example.movies_ch6_binar.model.User


@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Query("SELECT * FROM user_table WHERE username_user = :username")
    fun getUsername(username: String?): User

    @Update
    fun updateProfileUser(user: User): Int

    @Delete
    fun deleteUser(user: User): Int
}