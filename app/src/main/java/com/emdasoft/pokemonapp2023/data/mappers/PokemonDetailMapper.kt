package com.emdasoft.pokemonapp2023.data.mappers

import com.emdasoft.pokemonapp2023.data.api.models.PokemonResponse
import com.emdasoft.pokemonapp2023.data.api.models.SpriteResponse
import com.emdasoft.pokemonapp2023.data.api.models.TypeResponse
import com.emdasoft.pokemonapp2023.data.api.models.TypesResponse
import com.emdasoft.pokemonapp2023.domain.entity.Pokemon
import com.emdasoft.pokemonapp2023.domain.entity.Sprite
import com.emdasoft.pokemonapp2023.domain.entity.Type
import com.emdasoft.pokemonapp2023.domain.entity.Types

class PokemonDetailMapper {

    private fun mapSpriteApiToEntitySprite(sprite: SpriteResponse) = Sprite(
        frontDefault = sprite.frontDefault
    )

    private fun mapTypeApiToEntityType(type: TypeResponse) = Type(
        name = type.name
    )

    private fun mapTypesApiToEntityTypes(types: TypesResponse) = Types(
        types = mapTypeApiToEntityType(types.types)
    )

    private fun mapListApiTypesToTypes(list: List<TypesResponse>) = list.map {
        mapTypesApiToEntityTypes(it)
    }

    fun mapApiModelToEntity(pokemon: PokemonResponse) = Pokemon(
        id = pokemon.id,
        name = pokemon.name,
        weight = pokemon.weight,
        height = pokemon.height,
        sprites = mapSpriteApiToEntitySprite(pokemon.sprites),
        types = mapListApiTypesToTypes(pokemon.types)
    )

}
