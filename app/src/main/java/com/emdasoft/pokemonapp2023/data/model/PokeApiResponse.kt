package com.emdasoft.pokemonapp2023.data.model

data class PokeApiResponse (
    val count: Int,
    val results: List<PokeResultResponse>
)

data class PokeResultResponse (
    val name: String
)