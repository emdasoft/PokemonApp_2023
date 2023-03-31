package com.emdasoft.pokemonapp2023.domain.usecases

import com.emdasoft.pokemonapp2023.domain.models.PokeResult
import com.emdasoft.pokemonapp2023.domain.repository.Repository

class GetPokemonListUseCase(private val repository: Repository) {

    suspend fun getPokemonList(): List<PokeResult> {
        return repository.getPokemonList()
    }

}