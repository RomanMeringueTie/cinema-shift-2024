package com.example.cinemashift.common.data.network

import com.example.cinemashift.movielist.data.model.Movie
import com.example.cinemashift.movielist.data.model.MovieList
import retrofit2.http.GET

interface MovieApi {
    @GET("today")
    suspend fun getList(): MovieList
    @GET("film/{id}")
    suspend fun getById(id: Int): Movie
}