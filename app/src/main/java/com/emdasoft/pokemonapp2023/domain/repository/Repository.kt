package com.emdasoft.pokemonapp2023.domain.repository

import com.emdasoft.pokemonapp2023.domain.entity.PokeResult
import com.emdasoft.pokemonapp2023.domain.entity.Pokemon

interface Repository {

    suspend fun getPokemonList(): List<PokeResult>

    suspend fun getPokemonDetails(pokemonId: Int): Pokemon?

}