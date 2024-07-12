package com.example.cinemashift.moviedetails.domain.usecase

import com.example.cinemashift.common.data.model.Actor
import com.example.cinemashift.common.data.model.Country
import com.example.cinemashift.common.data.model.Movie
import com.example.cinemashift.common.data.model.UserRating
import com.example.cinemashift.moviedetails.data.repository.MovieDetailsRepository
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class GetMovieByIdUseCaseTest
{
    private val useCase = GetMovieByIdUseCase()
    private val repository: MovieDetailsRepository = mock()
    @Test
    fun `invoke EXPECT movie by id`()  = runTest {
        val id = "8"
        val expected = Movie(
            id = id,
            name = "Зелёный слоник",
            originalName = "Зелёный слоник",
            description = "Два младших офицера, сидя в одной камере на гауптвахте, вынуждены решать острые социальные и психологические вопросы в небольшом пространстве.",
            releaseDate = "1999",
            actors =  listOf(
                Actor(
                    id = "1",
                    professions = listOf("Актёр", "Режиссёр"),
                    fullName = "Владимир Епифанцев"
                ),
                Actor(
                    id = "2",
                    professions = listOf("Актёр"),
                    fullName = "Сергей Пахомов"
                ),
                Actor(
                    id = "3",
                    professions = listOf("Актёр"),
                    fullName = "Александр Маслаев"
                ),
                Actor(
                    id = "4",
                    professions = listOf("Актёр"),
                    fullName = "Анатолий Осмоловский"
                )
            ),
            directors = listOf(Actor(
                id = "1",
                professions = listOf("Режиссёр"),
                fullName = "Светлана Баскова"
            )),
            runtime = 86,
            ageRating = "18+",
            genres = listOf("ужасы, триллер"),
            userRatings =UserRating(
                kinopoisk = "5.6",
                imdb = "5.3"
            ),
            img = "/static/images/cinema/film_8.webp",
            country = Country(
                name = "Россия",
                code = "RUS",
                code2 = "RU",
                id = 8
            )
        )
        whenever(repository.getById(id)).thenReturn(expected)

        val actual = useCase(id)

        assertEquals(actual, expected)
    }
}