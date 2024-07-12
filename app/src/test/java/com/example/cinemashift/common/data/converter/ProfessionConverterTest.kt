package com.example.cinemashift.common.data.converter

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ProfessionConverterTest
{
    private val converter = ProfessionConverter()

    @Test
    fun `convert profession model EXPECT profession`()
    {
        val professionModel = listOf("ACTOR", "DIRECTOR")
        val expected = listOf("Актёр", "Режиссёр")

        val actual = mutableListOf<String>()
        professionModel.map { actual.add(converter.convert(it)) }

        assertEquals(expected, actual.toList())
    }
}