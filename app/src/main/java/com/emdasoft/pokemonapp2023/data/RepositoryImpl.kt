package com.emdasoft.pokemonapp2023.data

import com.emdasoft.pokemonapp2023.domain.models.PokeName
import com.emdasoft.pokemonapp2023.domain.models.Pokemon
import com.emdasoft.pokemonapp2023.domain.repository.Repository

object RepositoryImpl : Repository {

    private val pokemonList = mutableListOf<PokeName>()
    private var autoIncrementID = 0

    init {
        for (item in 0..20) {
            pokemonList.add(PokeName(item.toString()))
        }
    }

    override fun getPokemonList(): List<PokeName> {
        return pokemonList.toList()
    }

    override fun getPokemonDetails(pokemonId: Int): Pokemon {
        return Pokemon(autoIncrementID++, pokemonList[pokemonId].toString(), 10, 10)
    }
}