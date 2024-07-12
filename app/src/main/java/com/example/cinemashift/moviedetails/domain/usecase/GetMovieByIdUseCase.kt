package com.example.cinemashift.moviedetails.domain.usecase

import com.example.cinemashift.moviedetails.data.repository.MovieDetailsRepository
import com.example.cinemashift.common.data.model.Movie

class GetMovieByIdUseCase {
    suspend operator fun invoke(id: String): Movie = MovieDetailsRepository().getById(id)
}