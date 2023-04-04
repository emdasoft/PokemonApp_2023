package com.emdasoft.pokemonapp2023.data.mappers

import com.emdasoft.pokemonapp2023.data.database.PokeNameDbModel
import com.emdasoft.pokemonapp2023.data.network.model.PokeNameDto
import com.emdasoft.pokemonapp2023.domain.entity.PokeName

class PokemonListMapper {

    private fun mapDtoModelToEntity(dto: PokeNameDto) = PokeName(
        name = dto.name
    )

    private fun mapDbModelToEntity(dbModel: PokeNameDbModel) = PokeName(
        name = dbModel.name
    )

    fun mapDtoToDbModel(dto: PokeNameDto) = PokeNameDbModel(
        name = dto.name
    )

    fun mapListDtoModelToListEntity(dtoList: List<PokeNameDto>) = dtoList.map {
        mapDtoModelToEntity(it)
    }

    fun mapListDbModelToListEntity(dbList: List<PokeNameDbModel>) = dbList.map {
        mapDbModelToEntity(it)
    }

    fun mapListDtoToListDbModel(dtoList: List<PokeNameDto>) = dtoList.map {
        mapDtoToDbModel(it)
    }

}
