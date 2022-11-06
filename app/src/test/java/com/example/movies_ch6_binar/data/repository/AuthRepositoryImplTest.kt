package com.example.movies_ch6_binar.data.repository

import com.example.movies_ch6_binar.Models.model.User
import com.example.movies_ch6_binar.data.local.entity.UserEntity
import com.example.movies_ch6_binar.data.local.room.dao.FavoriteDao
import com.example.movies_ch6_binar.data.local.room.dao.UserDao
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import retrofit2.Response


 class AuthRepositoryImplTest {
    private lateinit var userDao: UserDao
    private lateinit var repository: AuthRepositoryImpl
    private lateinit var favoriteMovieDao: FavoriteDao

    @Before
    fun setUp() {
        userDao = mock()
        favoriteMovieDao = mock()
        repository = AuthRepositoryImpl(userDao)
    }

    @Test
    fun Login() = runBlocking {
        val correct = mockk<UserEntity>()
        Mockito.`when`(userDao.login(any(), any())).thenReturn(correct)
        val response = repository.login("20082010137@student.upnjatim.ac.id", "adm123")
        assertEquals(response, correct)
    }

    @Test
    fun GetUser() = runBlocking {
        val correct = mockk<UserEntity>()
        Mockito.`when`(userDao.getUserData(any())).thenReturn(correct)
        val response = repository.getUserData("20082010137@student.upnjatim.ac.id")
        assertEquals(response, correct)
    }





}