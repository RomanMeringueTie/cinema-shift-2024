package com.example.cinemashift.common.data.converter

import android.content.res.Resources
import com.example.cinemashift.R

class AgeRatingConverter {
    fun convert(ageRatingModel: String): String {
        val ageRating: String =
        when (ageRatingModel) {
            "G" -> "0+"
            "PG" -> "6+"
            "PG13" -> "12+"
            "R" -> "16+"
            "NC17" -> "18+"
            else -> "-"
        }
        return ageRating
    }
}