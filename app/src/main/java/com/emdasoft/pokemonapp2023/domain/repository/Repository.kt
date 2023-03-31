package com.emdasoft.pokemonapp2023.domain.repository

import com.emdasoft.pokemonapp2023.domain.models.PokeName
import com.emdasoft.pokemonapp2023.domain.models.Pokemon

interface Repository {

    fun getPokemonList(): List<PokeName>

    fun getPokemonDetails(pokemonId: Int): Pokemon

}