package com.example.cinemashift.movielist.di

import com.example.cinemashift.movielist.domain.usecase.GetMovieListUseCase
import com.example.cinemashift.movielist.presentation.MovieListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val movieListModule = module {
    factoryOf(::GetMovieListUseCase)
    viewModelOf(::MovieListViewModel)
}