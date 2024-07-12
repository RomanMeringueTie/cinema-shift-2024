package com.example.cinemashift.common.data.converter

import android.content.res.Resources
import com.example.cinemashift.R

class ProfessionConverter {
    fun convert(professionModel: String): String {
        val profession: String =
        when (professionModel) {
            "ACTOR" -> "Актёр"
            "DIRECTOR" -> "Режиссёр"
            else -> "-"
        }
        return profession
    }
}