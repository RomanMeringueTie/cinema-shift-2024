package com.example.cinemashift.common.data.model

import kotlinx.serialization.Serializable

@Serializable
data class UserRating(
    val kinopoisk: String,
    val imdb: String
)
