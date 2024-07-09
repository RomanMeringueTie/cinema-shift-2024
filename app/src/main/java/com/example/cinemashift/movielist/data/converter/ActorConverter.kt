package com.example.cinemashift.movielist.data.converter

import com.example.cinemashift.movielist.data.model.Actor

class ActorConverter()
{
    fun convert(actorModel: Actor) = Actor(
        id = actorModel.id,
        professions = convertProfessionList(actorModel.professions),
        fullName = actorModel.fullName
    )
    private fun convertProfessionList(professionModelList: List<String>): List<String>
    {
        val result = mutableListOf<String>()
        for (i in professionModelList)
            result.add(ProfessionConverter().convert(i))
        return result
    }
}