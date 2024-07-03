package com.example.cinemashift.data

import kotlinx.serialization.Serializable

@Serializable
data class Country(
    val name: String,
    val code: String,
    val code2: String,
    val id: Int
)
