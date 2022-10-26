package com.example.movies_ch6_binar.Models.repository

import com.example.movies_ch6_binar.data.remote.dto.DetailDto
import com.example.movies_ch6_binar.data.remote.dto.MovieDto

interface MovieRepository {

    suspend fun getMovies(): List<MovieDto>

    suspend fun getMovieById(movieId: Int): DetailDto
}