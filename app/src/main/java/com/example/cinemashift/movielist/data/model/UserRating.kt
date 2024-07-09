package com.example.cinemashift.movielist.data.model

import kotlinx.serialization.Serializable

@Serializable
data class UserRating(
    val kinopoisk: String,
    val imdb: String
)
