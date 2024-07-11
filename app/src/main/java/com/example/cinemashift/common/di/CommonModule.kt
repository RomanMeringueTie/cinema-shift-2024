package com.example.cinemashift.common.di

import com.example.cinemashift.common.data.converter.ActorConverter
import com.example.cinemashift.common.data.converter.AgeRatingConverter
import com.example.cinemashift.common.data.converter.MovieConverter
import com.example.cinemashift.common.data.converter.MovieListConverter
import com.example.cinemashift.common.data.converter.ProfessionConverter
import com.example.cinemashift.common.data.network.MovieApi
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit

val commonModule = module {
    single { get<Retrofit>().create(MovieApi::class.java) }
    singleOf(::ActorConverter)
    singleOf(::AgeRatingConverter)
    singleOf(::MovieConverter)
    singleOf(::MovieListConverter)
    singleOf(::ProfessionConverter)
    singleOf(::MovieRepository)
}