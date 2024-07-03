package com.example.cinemashift.data

import kotlinx.serialization.Serializable

@Serializable
data class UserRating(
    val kinopoisk: String,
    val imdb: String
)
