package com.example.cinemashift.moviedetails.data.repository

import com.example.cinemashift.common.data.converter.MovieConverter
import com.example.cinemashift.common.data.repository.MovieRepository
import com.example.cinemashift.common.data.model.Movie

class MovieDetailsRepository: MovieRepository() {
    suspend fun getById(id: String): Movie =
        MovieConverter().convert(movieApi.getById(id).film)
}