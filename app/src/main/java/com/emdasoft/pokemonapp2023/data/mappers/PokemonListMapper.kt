package com.emdasoft.pokemonapp2023.data.mappers

import com.emdasoft.pokemonapp2023.data.network.model.PokeNameDto
import com.emdasoft.pokemonapp2023.domain.entity.PokeName

class PokemonListMapper {

    private fun mapApiModelToEntity(pokeName: PokeNameDto) = PokeName(
        name = pokeName.name
    )

    fun mapListApiModelToListEntity(list: List<PokeNameDto>) = list.map {
        mapApiModelToEntity(it)
    }

}
