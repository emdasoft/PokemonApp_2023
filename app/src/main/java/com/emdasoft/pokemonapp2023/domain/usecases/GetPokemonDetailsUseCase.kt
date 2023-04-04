package com.emdasoft.pokemonapp2023.domain.usecases

import com.emdasoft.pokemonapp2023.domain.entity.PokeInfo
import com.emdasoft.pokemonapp2023.domain.repository.Repository

class GetPokemonDetailsUseCase(private val repository: Repository) {

    suspend fun getPokemonDetails(pokemonId: Int): PokeInfo {
        return repository.getPokemonDetails(pokemonId)
    }

}