package com.example.cinemashift.common.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Actor(
    val id: String,
    val professions: List<String>,
    val fullName: String
)