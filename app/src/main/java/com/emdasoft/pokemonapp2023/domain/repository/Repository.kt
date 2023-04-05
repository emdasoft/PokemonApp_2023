package com.emdasoft.pokemonapp2023.domain.repository

import com.emdasoft.pokemonapp2023.domain.entity.PokeName
import com.emdasoft.pokemonapp2023.domain.entity.PokeInfo

interface Repository {

    suspend fun getPokemonList(): List<PokeName>

    suspend fun getPokemonDetails(pokemonName: String): PokeInfo

}