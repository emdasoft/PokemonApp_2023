package com.emdasoft.pokemonapp2023.data.mappers

import com.emdasoft.pokemonapp2023.data.api.models.PokeResultResponse
import com.emdasoft.pokemonapp2023.domain.models.PokeResult

class PokemonListMapper {

    fun mapApiModelToModel(pokeResult: PokeResultResponse) = PokeResult(
        name = pokeResult.name
    )

    fun mapListApiModelToListModel(list: List<PokeResultResponse>) = list.map {
        mapApiModelToModel(it)
    }

}
