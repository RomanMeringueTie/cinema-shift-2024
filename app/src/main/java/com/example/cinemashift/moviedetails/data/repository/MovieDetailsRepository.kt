package com.example.cinemashift.moviedetails.data.repository

import com.example.cinemashift.common.data.converter.MovieConverter
import com.example.cinemashift.common.data.model.Movie
import com.example.cinemashift.common.di.MovieRepository

class MovieDetailsRepository: MovieRepository() {
    suspend fun getById(id: String): Movie =
        MovieConverter().convert(movieApi.getById(id).film)
}