package com.emdasoft.pokemonapp2023.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    val id: Int,
    val name: String,
    val weight: Int,
    val height: Int,
    val sprites: SpriteResponse,
    val types: List<TypesResponse>
)

data class SpriteResponse(
    @Expose @SerializedName("front_default") val frontDefault: String?,
)

data class TypesResponse(
    @Expose @SerializedName("type") val types: TypeResponse,
)

data class TypeResponse(
    @Expose @SerializedName("name") val name: String
)
