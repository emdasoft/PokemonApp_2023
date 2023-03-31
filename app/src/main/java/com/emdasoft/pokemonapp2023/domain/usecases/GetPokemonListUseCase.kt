package com.emdasoft.pokemonapp2023.domain.usecases

import com.emdasoft.pokemonapp2023.domain.models.PokeName
import com.emdasoft.pokemonapp2023.domain.repository.Repository

class GetPokemonListUseCase(private val repository: Repository) {

    operator fun invoke(): List<PokeName> {
        return repository.getPokemonList()
    }

}