package com.emdasoft.pokemonapp2023.data

import android.app.Application
import com.emdasoft.pokemonapp2023.data.database.PokeDatabase
import com.emdasoft.pokemonapp2023.data.mappers.PokemonDetailMapper
import com.emdasoft.pokemonapp2023.data.mappers.PokemonListMapper
import com.emdasoft.pokemonapp2023.data.network.RetrofitInstance
import com.emdasoft.pokemonapp2023.domain.entity.PokeInfo
import com.emdasoft.pokemonapp2023.domain.entity.PokeName
import com.emdasoft.pokemonapp2023.domain.repository.Repository

class RepositoryImpl(application: Application) : Repository {

    private val listMapper = PokemonListMapper()
    private val modelMapper = PokemonDetailMapper()
    private val pokeListDao = PokeDatabase.getInstance(application).pokeListDao()

    override suspend fun getPokemonList(): List<PokeName> {
        return try {
            val response = RetrofitInstance.apiService.getPokemonList()
            listMapper.mapListDtoModelToListEntity(response.results)

        } catch (e: Exception) {
            listMapper.mapListDbModelToListEntity(pokeListDao.getPokemonListByName())
        }

    }

    override suspend fun getPokemonDetails(pokemonName: String): PokeInfo {

        return try {
            val pokemonResponse = RetrofitInstance.apiService.getPokemonInfo(
                pokemonName
            )
            pokeListDao.addPokemonInfo(modelMapper.mapDtoToDbModel(pokemonResponse))
            modelMapper.mapDbModelToEntity(pokeListDao.getPokemonInfo(pokemonName))
        } catch (e: Exception) {
            modelMapper.mapDbModelToEntity(pokeListDao.getPokemonInfo(pokemonName))
        }
    }

}
