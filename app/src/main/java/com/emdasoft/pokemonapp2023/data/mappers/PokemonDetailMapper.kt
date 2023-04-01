package com.emdasoft.pokemonapp2023.data.mappers

import com.emdasoft.pokemonapp2023.data.network.model.PokeInfoDto
import com.emdasoft.pokemonapp2023.data.network.model.PokeTypesDto
import com.emdasoft.pokemonapp2023.domain.entity.PokeInfo

class PokemonDetailMapper {

    private fun mapListApiTypesToTypes(list: List<PokeTypesDto>) = list.map {
        it.types.name
    }

    fun mapApiModelToEntity(pokemon: PokeInfoDto) = PokeInfo(
        id = pokemon.id,
        name = pokemon.name,
        weight = pokemon.weight,
        height = pokemon.height,
        sprite = pokemon.sprites.frontDefault,
        types = mapListApiTypesToTypes(pokemon.types)
    )

}
