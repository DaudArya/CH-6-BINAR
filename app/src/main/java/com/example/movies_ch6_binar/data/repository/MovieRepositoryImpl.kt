package com.example.movies_ch6_binar.data.repository


import com.example.movies_ch6_binar.data.remote.dto.DetailDto
import com.example.movies_ch6_binar.data.remote.dto.MovieDto
import com.example.movies_ch6_binar.data.remote.dto.TheMovieDbApi
import com.example.movies_ch6_binar.Models.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: TheMovieDbApi
) : MovieRepository {

    override suspend fun getMovies(): List<MovieDto> {
        return api.getMovies("acb0afb6699c9aa6945f1d6a3f1ec89c").result
    }

    override suspend fun getMovieById(movieId: Int): DetailDto {
        return api.getMovieById(movieId, "acb0afb6699c9aa6945f1d6a3f1ec89c")
    }
}