package com.example.cinemashift.common.data.converter

import com.example.cinemashift.common.data.model.Actor
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class ActorConverterTest
{
    private val converter = ActorConverter()

    @Test
    fun `convert actor model EXPECT actor`() {
        val actorModel = Actor(
            id = "1",
            professions = listOf("ACTOR", "DIRECTOR"),
            fullName = "Tommy Wiseau"
        )
        val expected = Actor(
            id = "1",
            professions = listOf("Актёр", "Режиссёр"),
            fullName = "Tommy Wiseau"
        )

        val actual = converter.convert(actorModel)

        assertEquals(expected, actual)
    }
}