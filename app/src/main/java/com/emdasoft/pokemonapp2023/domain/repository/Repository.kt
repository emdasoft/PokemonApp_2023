package com.emdasoft.pokemonapp2023.domain.repository

import com.emdasoft.pokemonapp2023.domain.models.PokeResult
import com.emdasoft.pokemonapp2023.domain.models.Pokemon

interface Repository {

    suspend fun getPokemonList(): List<PokeResult>

    suspend fun getPokemonDetails(pokemonId: Int): Pokemon?

}