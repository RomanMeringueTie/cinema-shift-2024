package com.example.cinemashift.data

import kotlinx.serialization.Serializable

@Serializable
data class MovieItem(
    val id: String,
    val name: String,
    val originalName: String,
    val description: String,
    val releaseDate: String,
    val actors: List<Actor>,
    val directors: List<Actor>,
    val runtime: Int,
    val ageRating: String,
    val genres: List<String>,
    val userRatings: UserRating,
    val img: String,
    val country: Country
)