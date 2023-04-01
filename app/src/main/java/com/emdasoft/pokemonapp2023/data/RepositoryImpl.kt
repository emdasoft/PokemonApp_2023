package com.emdasoft.pokemonapp2023.data

import com.emdasoft.pokemonapp2023.data.mappers.PokemonDetailMapper
import com.emdasoft.pokemonapp2023.data.mappers.PokemonListMapper
import com.emdasoft.pokemonapp2023.data.network.RetrofitInstance
import com.emdasoft.pokemonapp2023.domain.entity.PokeName
import com.emdasoft.pokemonapp2023.domain.entity.PokeInfo
import com.emdasoft.pokemonapp2023.domain.repository.Repository

object RepositoryImpl : Repository {

    private val listMapper = PokemonListMapper()
    private val modelMapper = PokemonDetailMapper()

    override suspend fun getPokemonList(): List<PokeName> {
        val response = RetrofitInstance.apiService.getPokemonList()
        response.body()?.let {
            return listMapper.mapListApiModelToListEntity(it.results)
        }
        return emptyList()
    }

    override suspend fun getPokemonDetails(pokemonId: Int): PokeInfo? {
        val pokemonResponse = RetrofitInstance.apiService.getPokemonInfo(
            pokemonId
        )
        return pokemonResponse.body()?.let {
            modelMapper.mapApiModelToEntity(it)
        }
    }
}