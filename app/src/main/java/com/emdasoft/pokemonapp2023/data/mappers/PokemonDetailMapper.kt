package com.emdasoft.pokemonapp2023.data.mappers

import com.emdasoft.pokemonapp2023.data.api.models.PokemonResponse
import com.emdasoft.pokemonapp2023.data.api.models.SpriteResponse
import com.emdasoft.pokemonapp2023.data.api.models.TypeResponse
import com.emdasoft.pokemonapp2023.data.api.models.TypesResponse
import com.emdasoft.pokemonapp2023.domain.models.Pokemon
import com.emdasoft.pokemonapp2023.domain.models.Sprite
import com.emdasoft.pokemonapp2023.domain.models.Type
import com.emdasoft.pokemonapp2023.domain.models.Types

class PokemonDetailMapper {

    private fun mapSpriteApiToModelSprite(sprite: SpriteResponse) = Sprite(
        frontDefault = sprite.frontDefault
    )

    private fun mapTypeApiToModelType(type: TypeResponse) = Type(
        name = type.name
    )

    private fun mapTypesApiToModelTypes(types: TypesResponse) = Types(
        types = mapTypeApiToModelType(types.types)
    )

    private fun mapListApiTypesToTypes(list: List<TypesResponse>) = list.map {
        mapTypesApiToModelTypes(it)
    }

    fun mapApiModelToModel(pokemon: PokemonResponse) = Pokemon(
        id = pokemon.id,
        name = pokemon.name,
        weight = pokemon.weight,
        height = pokemon.height,
        sprites = mapSpriteApiToModelSprite(pokemon.sprites),
        types = mapListApiTypesToTypes(pokemon.types)
    )

}
