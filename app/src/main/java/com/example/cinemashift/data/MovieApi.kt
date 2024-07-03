package com.example.cinemashift.data

import retrofit2.http.GET

interface MovieApi {
    @GET("today")
    suspend fun getMovieList(): MovieListItem
}