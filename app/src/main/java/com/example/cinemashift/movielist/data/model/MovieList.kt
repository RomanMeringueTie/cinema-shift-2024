package com.example.cinemashift.movielist.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MovieList(
    val success: Boolean,
    val films: List<Movie>
)