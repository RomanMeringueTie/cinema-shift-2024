package com.example.cinemashift.movielist.presentation

import com.example.cinemashift.movielist.data.model.MovieList

sealed interface MovieListState
{
    data object Initial: MovieListState
    data object Loading: MovieListState
    data class Failure(val message: String?): MovieListState
    data class Content(val movieListItem: MovieList): MovieListState
}