package com.example.cinemashift.moviedetails.di

import com.example.cinemashift.moviedetails.domain.usecase.GetMovieByIdUseCase
import com.example.cinemashift.moviedetails.presentation.MovieDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val movieDetailsModule = module {
    factoryOf(::GetMovieByIdUseCase)
    viewModelOf(::MovieDetailsViewModel)
}