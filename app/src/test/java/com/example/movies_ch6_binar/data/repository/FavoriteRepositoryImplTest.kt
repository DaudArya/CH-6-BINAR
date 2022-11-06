package com.example.movies_ch6_binar.data.repository

import com.example.movies_ch6_binar.Models.model.Favorite
import com.example.movies_ch6_binar.Models.model.Movie
import com.example.movies_ch6_binar.Models.model.User
import com.example.movies_ch6_binar.data.local.entity.FavoriteEntity
import com.example.movies_ch6_binar.data.local.entity.UserEntity
import com.example.movies_ch6_binar.data.local.room.dao.FavoriteDao
import com.example.movies_ch6_binar.data.local.room.dao.UserDao
import com.example.movies_ch6_binar.data.remote.dto.DetailDto
import com.example.movies_ch6_binar.data.remote.dto.MovieDto
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import junit.framework.Assert
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import retrofit2.Response

class FavoriteRepositoryImplTest {
    private lateinit var userDao: UserDao
    private lateinit var repository: FavoriteRepositoryImpl
    private lateinit var favoriteMovieDao: FavoriteDao


    @Before
    fun setUp() {
        userDao = mock()
        favoriteMovieDao = mock()
        repository = FavoriteRepositoryImpl(favoriteMovieDao)
    }








}