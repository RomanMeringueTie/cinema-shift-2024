package com.example.cinemashift.movielist.data.converter

import com.example.cinemashift.movielist.data.model.MovieList
import com.example.cinemashift.movielist.data.model.Movie

class MovieListConverter() {
    fun convert(movieListModel: MovieList) = MovieList(
        success = movieListModel.success,
        films = convertMovieModelList(movieListModel.films)
    )
    fun convertMovieModelList(movieModelList: List<Movie>): List<Movie>
    {
        val result = mutableListOf<Movie>()
        for (i in movieModelList)
            result.add(MovieConverter().convert(i))
        return result
    }
}