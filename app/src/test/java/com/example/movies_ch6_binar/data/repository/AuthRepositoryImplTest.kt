package com.example.movies_ch6_binar.data.repository

import com.example.movies_ch6_binar.Models.model.User
import com.example.movies_ch6_binar.data.local.entity.UserEntity
import com.example.movies_ch6_binar.data.local.room.dao.FavoriteDao
import com.example.movies_ch6_binar.data.local.room.dao.UserDao
import com.example.movies_ch6_binar.data.remote.dto.DetailDto
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
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


     @Test
     fun getUsers(): Unit = runBlocking {
         val respAllMovie = mockk<Long>()

         every {
             runBlocking {
                 userDao.register(user = UserEntity(1,"adam","Adam","20082010137@student.upnjatim.ac.id","adm123","Surabaya","26-01-2002",null))
             }
         } returns respAllMovie

         repository.register(user = UserEntity(1,"","","","","","",null))

         verify {
             runBlocking { userDao.register(user = UserEntity(1,"adam","Adam","20082010137@student.upnjatim.ac.id","adm123","Surabaya","26-01-2002",null)) }
         }
     }





}