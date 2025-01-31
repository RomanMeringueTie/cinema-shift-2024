package com.example.cinemashift.movielist.data.model

import com.example.cinemashift.common.data.model.Movie
import kotlinx.serialization.Serializable

@Serializable
data class MovieList(
    val success: Boolean,
    val films: List<Movie>
)