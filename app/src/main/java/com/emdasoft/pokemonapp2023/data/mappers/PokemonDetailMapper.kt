package com.emdasoft.pokemonapp2023.data.mappers

import com.emdasoft.pokemonapp2023.data.model.PokemonResponse
import com.emdasoft.pokemonapp2023.data.model.SpriteResponse
import com.emdasoft.pokemonapp2023.data.model.TypeResponse
import com.emdasoft.pokemonapp2023.data.model.TypesResponse
import com.emdasoft.pokemonapp2023.domain.entity.PokeInfo
import com.emdasoft.pokemonapp2023.domain.entity.PokeSprite
import com.emdasoft.pokemonapp2023.domain.entity.PokeType
import com.emdasoft.pokemonapp2023.domain.entity.PokeTypes

class PokemonDetailMapper {

    private fun mapSpriteApiToEntitySprite(sprite: SpriteResponse) = PokeSprite(
        frontDefault = sprite.frontDefault
    )

    private fun mapTypeApiToEntityType(type: TypeResponse) = PokeType(
        name = type.name
    )

    private fun mapTypesApiToEntityTypes(types: TypesResponse) = PokeTypes(
        types = mapTypeApiToEntityType(types.types)
    )

    private fun mapListApiTypesToTypes(list: List<TypesResponse>) = list.map {
        mapTypesApiToEntityTypes(it)
    }

    fun mapApiModelToEntity(pokemon: PokemonResponse) = PokeInfo(
        id = pokemon.id,
        name = pokemon.name,
        weight = pokemon.weight,
        height = pokemon.height,
        sprites = mapSpriteApiToEntitySprite(pokemon.sprites),
        types = mapListApiTypesToTypes(pokemon.types)
    )

}
