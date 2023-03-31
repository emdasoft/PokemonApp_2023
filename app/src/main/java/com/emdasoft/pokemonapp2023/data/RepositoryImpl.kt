package com.emdasoft.pokemonapp2023.data

import com.emdasoft.pokemonapp2023.data.mappers.PokemonDetailMapper
import com.emdasoft.pokemonapp2023.data.mappers.PokemonListMapper
import com.emdasoft.pokemonapp2023.data.retrofit.RetrofitInstance
import com.emdasoft.pokemonapp2023.domain.models.PokeResult
import com.emdasoft.pokemonapp2023.domain.models.Pokemon
import com.emdasoft.pokemonapp2023.domain.repository.Repository

object RepositoryImpl : Repository {

    private val listMapper = PokemonListMapper()
    private val modelMapper = PokemonDetailMapper()

    override suspend fun getPokemonList(): List<PokeResult> {
        val response = RetrofitInstance.apiService.getPokemonList()
        response.body()?.let {
            return listMapper.mapListApiModelToListModel(it.results)
        }
        return emptyList()
    }

    override suspend fun getPokemonDetails(pokemonId: Int): Pokemon? {
        val pokemonResponse = RetrofitInstance.apiService.getPokemonInfo(
            pokemonId
        )
        return pokemonResponse.body()?.let {
            modelMapper.mapApiModelToModel(it)
        }
    }
}