package com.example.cinemashift.movielist.data.converter

import com.example.cinemashift.movielist.data.model.Actor
import com.example.cinemashift.movielist.data.model.Movie

class MovieConverter {
    fun convert(movieModel: Movie) = Movie(
        id = movieModel.id,
        name = movieModel.name,
        originalName = movieModel.originalName,
        description = movieModel.description,
        releaseDate = movieModel.releaseDate,
        actors = convertActorList(movieModel.actors),
        directors = convertActorList(movieModel.directors),
        runtime = movieModel.runtime,
        ageRating = AgeRatingConverter().convert(movieModel.ageRating),
        genres = movieModel.genres,
        userRatings = movieModel.userRatings,
        img = movieModel.img,
        country = movieModel.country
        )
    private fun convertActorList(actorModelList: List<Actor>): List<Actor>
    {
        val result = mutableListOf<Actor>()
        for (i in actorModelList)
            result.add(ActorConverter().convert(i))
        return result
    }
}