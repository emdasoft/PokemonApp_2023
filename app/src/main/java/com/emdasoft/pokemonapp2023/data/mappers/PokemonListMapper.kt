package com.emdasoft.pokemonapp2023.data.mappers

import com.emdasoft.pokemonapp2023.data.model.PokeResultResponse
import com.emdasoft.pokemonapp2023.domain.entity.PokeName

class PokemonListMapper {

    private fun mapApiModelToEntity(pokeResult: PokeResultResponse) = PokeName(
        name = pokeResult.name
    )

    fun mapListApiModelToListEntity(list: List<PokeResultResponse>) = list.map {
        mapApiModelToEntity(it)
    }

}
