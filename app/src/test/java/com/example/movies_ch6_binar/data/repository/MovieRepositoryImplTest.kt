package com.example.movies_ch6_binar.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.movies_ch6_binar.Models.model.Movie
import com.example.movies_ch6_binar.Models.usecase.movielist.GetMovieListUseCase
import com.example.movies_ch6_binar.data.remote.dto.DetailDto
import com.example.movies_ch6_binar.data.remote.dto.MovieDto
import com.example.movies_ch6_binar.data.remote.dto.ResultDto
import com.example.movies_ch6_binar.data.remote.dto.TheMovieDbApi
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.stubbing.OngoingStubbing
import retrofit2.Response


class MovieRepositoryImplTest{
    private lateinit var api: TheMovieDbApi
    private lateinit var repository: MovieRepositoryImpl


    @Before
    fun setUp() {
        api = mock()
        repository = MovieRepositoryImpl(api)
    }

    @Test
    fun getMovieById() = runBlocking {
        val correct = mockk<DetailDto>()
        Mockito.`when`(api.getMovieById(any(), any())).thenReturn(correct)
        val response = repository.getMovieById(32)
        assertEquals(correct, response)
    }





}





