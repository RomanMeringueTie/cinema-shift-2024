package com.example.cinemashift.movielist.data.repository

import com.example.cinemashift.common.data.repository.MovieRepository
import com.example.cinemashift.common.data.converter.MovieListConverter
import com.example.cinemashift.movielist.data.model.MovieList

class MovieListRepository: MovieRepository() {
    suspend fun getMovieList(): MovieList =
        MovieListConverter().convert(movieApi.getList())
}