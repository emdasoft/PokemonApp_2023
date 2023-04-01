package com.emdasoft.pokemonapp2023.domain.usecases

import com.emdasoft.pokemonapp2023.domain.entity.Pokemon
import com.emdasoft.pokemonapp2023.domain.repository.Repository

class GetPokemonDetailsUseCase(private val repository: Repository) {

    suspend fun getPokemonDetails(pokemonId: Int): Pokemon? {
        return repository.getPokemonDetails(pokemonId)
    }

}