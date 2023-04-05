package com.emdasoft.pokemonapp2023.data.mappers

import com.emdasoft.pokemonapp2023.data.database.PokeInfoDbModel
import com.emdasoft.pokemonapp2023.data.network.model.PokeInfoDto
import com.emdasoft.pokemonapp2023.data.network.model.PokeTypesDto
import com.emdasoft.pokemonapp2023.domain.entity.PokeInfo

class PokemonDetailMapper {

    private fun mapTypesListToString(list: List<PokeTypesDto>): String {
        return list.joinToString(",") {
            it.types.name
        }
    }

    private fun mapDbModelTypesToEntity(dbModelTypes: String): List<String> {
        return dbModelTypes.split(",").toList()
    }

    fun mapDtoToDbModel(dto: PokeInfoDto) = PokeInfoDbModel(
        id = dto.id,
        name = dto.name,
        weight = dto.weight,
        height = dto.height,
        sprite = dto.sprites.frontDefault,
        types = mapTypesListToString(dto.types)
    )

    fun mapDbModelToEntity(dbModel: PokeInfoDbModel) = PokeInfo(
        id = dbModel.id,
        name = dbModel.name,
        weight = dbModel.weight,
        height = dbModel.height,
        sprite = dbModel.sprite,
        types = mapDbModelTypesToEntity(dbModel.types)
    )

//    unused mapper, maybe need them later...

//    fun mapDtoModelToEntity(pokemon: PokeInfoDto) = PokeInfo(
//        id = pokemon.id,
//        name = pokemon.name,
//        weight = pokemon.weight,
//        height = pokemon.height,
//        sprite = pokemon.sprites.frontDefault,
//        types = mapListDtoTypesToTypes(pokemon.types)
//    )

//    private fun mapListDtoTypesToTypes(list: List<PokeTypesDto>) = list.map {
//        it.types.name
//    }
}
