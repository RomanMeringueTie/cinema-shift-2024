package com.example.cinemashift.common.data.converter

import com.example.cinemashift.movielist.data.model.MovieList
import com.example.cinemashift.common.data.model.Movie

class MovieListConverter {
    fun convert(movieListModel: MovieList) = MovieList(
        success = movieListModel.success,
        films = convertMovieModelList(movieListModel.films)
    )
    private fun convertMovieModelList(movieModelList: List<Movie>): List<Movie>
    {
        val result = mutableListOf<Movie>()
        for (i in movieModelList)
            result.add(MovieConverter().convert(i))
        return result
    }
}