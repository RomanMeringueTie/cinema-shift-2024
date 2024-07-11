package com.example.cinemashift.moviedetails.presentation

import com.example.cinemashift.common.data.model.Movie
import com.example.cinemashift.movielist.data.model.MovieList
import com.example.cinemashift.movielist.presentation.MovieListState

sealed interface MovieItemState
{
    data object Initial: MovieItemState
    data object Loading: MovieItemState
    data class Failure(val message: String?): MovieItemState
    data class Content(val movieItem: Movie): MovieItemState
}