package com.example.cinemashift.moviedetails.data.model

import com.example.cinemashift.common.data.model.Movie
import kotlinx.serialization.Serializable

@Serializable
data class MovieItem(
    val success: Boolean,
    val film: Movie
)