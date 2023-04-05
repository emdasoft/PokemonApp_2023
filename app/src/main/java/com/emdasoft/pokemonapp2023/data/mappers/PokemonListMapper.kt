package com.emdasoft.pokemonapp2023.data.mappers

import com.emdasoft.pokemonapp2023.data.database.PokeInfoDbModel
import com.emdasoft.pokemonapp2023.data.network.model.PokeNameDto
import com.emdasoft.pokemonapp2023.domain.entity.PokeName

class PokemonListMapper {

    private fun mapDtoModelToEntity(dto: PokeNameDto) = PokeName(
        name = dto.name
    )

    fun mapListDtoModelToListEntity(dtoList: List<PokeNameDto>) = dtoList.map {
        mapDtoModelToEntity(it)
    }

    fun mapListDbModelToListEntity(dbList: List<PokeInfoDbModel>) = dbList.map {
        mapNameDbModelToEntity(it)
    }

    private fun mapNameDbModelToEntity(dbModel: PokeInfoDbModel) = PokeName(
        name = dbModel.name
    )

//    unused mapper, maybe need them later...
//    fun mapListDtoToListDbModel(dtoList: List<PokeNameDto>) = dtoList.map {
//        mapDtoToDbModel(it)
//    }
//    private fun mapDbModelToEntity(dbModel: PokeNameDbModel) = PokeName(
//        name = dbModel.name
//    )
//
//    private fun mapDtoToDbModel(dto: PokeNameDto) = PokeNameDbModel(
//        name = dto.name
//    )

}
