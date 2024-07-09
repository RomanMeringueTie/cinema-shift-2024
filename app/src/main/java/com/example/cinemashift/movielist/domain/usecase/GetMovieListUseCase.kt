package com.example.cinemashift.movielist.domain.usecase

import com.example.cinemashift.movielist.data.model.MovieList
import com.example.cinemashift.movielist.data.repository.MovieListRepository

class GetMovieListUseCase {
    suspend operator fun invoke(): MovieList = MovieListRepository().getMovieList()
}