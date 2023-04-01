package com.emdasoft.pokemonapp2023.domain.entity

data class PokeInfo(
    val id: Int,
    val name: String,
    val weight: Int,
    val height: Int,
    val sprites: PokeSprite,
    val types: List<PokeTypes>
)

