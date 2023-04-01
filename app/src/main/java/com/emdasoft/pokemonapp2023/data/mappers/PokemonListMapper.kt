package com.emdasoft.pokemonapp2023.data.mappers

import com.emdasoft.pokemonapp2023.data.api.models.PokeResultResponse
import com.emdasoft.pokemonapp2023.domain.entity.PokeResult

class PokemonListMapper {

    fun mapApiModelToEntity(pokeResult: PokeResultResponse) = PokeResult(
        name = pokeResult.name
    )

    fun mapListApiModelToListEntity(list: List<PokeResultResponse>) = list.map {
        mapApiModelToEntity(it)
    }

}
