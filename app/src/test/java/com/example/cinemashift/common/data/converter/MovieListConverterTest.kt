package com.example.cinemashift.common.data.converter

import com.example.cinemashift.common.data.model.Actor
import com.example.cinemashift.common.data.model.Country
import com.example.cinemashift.common.data.model.Movie
import com.example.cinemashift.common.data.model.UserRating
import com.example.cinemashift.movielist.data.model.MovieList
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MovieListConverterTest
{
    private val converter = MovieListConverter()

    @Test
    fun `convert movie list model EXPECT movie list`()
    {
        val movieListModel = MovieList(
            success = true,
            films = listOf(
            Movie(
            id = "0",
            name = "Комната",
            originalName = "The Room",
            description = "У Джонни есть всё — отличная работа, квартира в Сан-Франциско, лучший друг Марк и невеста Лиза, и близится его день рождения. Но все меняется, когда Марк и Лиза заводят роман…",
            releaseDate = "2003",
            actors =  listOf(
                Actor(id = "1",
                professions = listOf("ACTOR", "DIRECTOR"),
                fullName = "Tommy Wiseau")
            ),
            directors = listOf(
                Actor(id = "1",
                professions = listOf("ACTOR", "DIRECTOR"),
                fullName = "Tommy Wiseau")
            ),
            runtime = 99,
            ageRating = "R",
            genres = listOf("драма, мелодрама"),
            userRatings = UserRating(
                kinopoisk = "4.8",
                imdb = "3,6"
            ),
            img = "https://upload.wikimedia.org/wikipedia/en/e/e1/TheRoomMovie.jpg",
            country = Country(
                name = "США",
                code = "USA",
                code2 = "US",
                id = 1
            )
        )
        )
        )
        val expected = MovieList(
            success = true,
            films = listOf(Movie(
            id = "0",
            name = "Комната",
            originalName = "The Room",
            description = "У Джонни есть всё — отличная работа, квартира в Сан-Франциско, лучший друг Марк и невеста Лиза, и близится его день рождения. Но все меняется, когда Марк и Лиза заводят роман…",
            releaseDate = "2003",
            actors =  listOf(Actor(id = "1",
                professions = listOf("Актёр", "Режиссёр"),
                fullName = "Tommy Wiseau")),
            directors = listOf(Actor(id = "1",
                professions = listOf("Актёр", "Режиссёр"),
                fullName = "Tommy Wiseau")),
            runtime = 99,
            ageRating = "16+",
            genres = listOf("драма, мелодрама"),
            userRatings =UserRating(
                kinopoisk = "4.8",
                imdb = "3,6"
            ),
            img = "https://upload.wikimedia.org/wikipedia/en/e/e1/TheRoomMovie.jpg",
            country = Country(
                name = "США",
                code = "USA",
                code2 = "US",
                id = 1
            )
        )
        )
        )

        val actual = converter.convert(movieListModel)

        assertEquals(expected, actual)
    }
}