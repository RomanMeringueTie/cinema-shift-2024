package com.example.cinemashift.data

import kotlinx.serialization.Serializable

@Serializable
data class Actor(
    val id: String,
    val professions: List<String>,
    val fullName: String
)
