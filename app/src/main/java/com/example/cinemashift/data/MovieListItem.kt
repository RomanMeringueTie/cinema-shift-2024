package com.example.cinemashift.data

import kotlinx.serialization.Serializable

@Serializable
data class MovieListItem(
    val success: Boolean,
    val films: List<MovieItem>
)