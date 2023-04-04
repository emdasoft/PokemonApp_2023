package com.emdasoft.pokemonapp2023.data

import android.app.Application
import com.emdasoft.pokemonapp2023.data.database.PokeDatabase
import com.emdasoft.pokemonapp2023.data.mappers.PokemonDetailMapper
import com.emdasoft.pokemonapp2023.data.mappers.PokemonListMapper
import com.emdasoft.pokemonapp2023.data.network.RetrofitInstance
import com.emdasoft.pokemonapp2023.data.network.model.PokeInfoDto
import com.emdasoft.pokemonapp2023.domain.entity.PokeInfo
import com.emdasoft.pokemonapp2023.domain.entity.PokeName
import com.emdasoft.pokemonapp2023.domain.repository.Repository

class RepositoryImpl(application: Application) : Repository {

    private val listMapper = PokemonListMapper()
    private val modelMapper = PokemonDetailMapper()
    private val pokeListDao = PokeDatabase.getInstance(application).pokeListDao()

    override suspend fun getPokemonList(): List<PokeName> {
        try {
            val response = RetrofitInstance.apiService.getPokemonList()
            response.results.forEach {
                pokeListDao.addPokemonName(listMapper.mapDtoToDbModel(it))
            }
        } catch (e: Exception) {
        }
        return listMapper.mapListDbModelToListEntity(pokeListDao.getPokemonList())
//        return listMapper.mapListDtoModelToListEntity(response.results)

//        val response = RetrofitInstance.apiService.getPokemonList()
//        response.body()?.let {
//            it.results.forEach {
//                pokeListDao.addPokemonName(listMapper.mapDtoToDbModel(it))
//            }
//        }
//
//        return listMapper.mapListDbModelToListEntity(pokeListDao.getPokemonList())

//        val response = RetrofitInstance.apiService.getPokemonList()
//        response.body()?.let {
//            return listMapper.mapListDtoModelToListEntity(it.results)
//        }
//        return emptyList()
    }

    override suspend fun getPokemonDetails(pokemonId: Int): PokeInfo {

        try {
            val pokemonResponse = RetrofitInstance.apiService.getPokemonInfo(
                pokemonId
            )
            pokeListDao.addPokemonInfo(modelMapper.mapDtoToDbModel(pokemonResponse))
        } catch (e: Exception) {

        }


        return modelMapper.mapDbModelToEntity(pokeListDao.getPokemonInfo(pokemonId))
        //        return pokemonResponse.body()?.let {
//            modelMapper.mapApiModelToEntity(it)
//        }
    }
}