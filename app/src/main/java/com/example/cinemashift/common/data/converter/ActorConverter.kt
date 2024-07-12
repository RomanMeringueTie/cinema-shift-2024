package com.example.cinemashift.common.data.converter

import com.example.cinemashift.common.data.model.Actor

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