package com.emdasoft.pokemonapp2023.data.network.model

data class PokeApiResponse (
    val count: Int,
    val results: List<PokeNameDto>
)
