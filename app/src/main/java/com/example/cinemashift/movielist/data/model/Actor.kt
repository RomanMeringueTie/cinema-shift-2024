package com.example.cinemashift.movielist.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Actor(
    val id: String,
    val professions: List<String>,
    val fullName: String
)