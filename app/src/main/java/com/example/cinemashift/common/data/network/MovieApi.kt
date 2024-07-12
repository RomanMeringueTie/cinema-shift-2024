package com.example.cinemashift.common.data.network

import com.example.cinemashift.common.data.model.Movie
import com.example.cinemashift.moviedetails.data.model.MovieItem
import com.example.cinemashift.movielist.data.model.MovieList
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {
    @GET("today")
    suspend fun getList(): MovieList
    @GET("film/{id}")
    suspend fun getById(@Path("id") id: String): MovieItem
}