package com.emdasoft.pokemonapp2023.data.network.model

data class PokeInfoDto(
    val id: Int,
    val name: String,
    val weight: Int,
    val height: Int,
    val sprites: PokeSpriteDto,
    val types: List<PokeTypesDto>
)