package com.emdasoft.pokemonapp2023.domain.usecases

import com.emdasoft.pokemonapp2023.domain.entity.PokeName
import com.emdasoft.pokemonapp2023.domain.repository.Repository

class GetPokemonListUseCase(private val repository: Repository) {

    suspend fun getPokemonList(): List<PokeName> {
        return repository.getPokemonList()
    }

}