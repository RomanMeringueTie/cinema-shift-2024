package com.example.cinemashift.common.data.converter

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AgeRatingConverterTest
{
    private val converter = AgeRatingConverter()

    @Test
    fun `convert age rating model EXPECT age rating`()
    {
        val ageRatingModel = listOf("G", "PG", "PG13", "R", "NC17", "lol")
        val expected = listOf("0+", "6+", "12+", "16+", "18+", "-")

        val actual = mutableListOf<String>()
        ageRatingModel.map { actual.add(converter.convert(it)) }

        assertEquals(expected, actual.toList())
    }
}