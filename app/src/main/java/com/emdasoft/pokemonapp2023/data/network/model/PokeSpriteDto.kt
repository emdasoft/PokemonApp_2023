package com.emdasoft.pokemonapp2023.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PokeSpriteDto(
    @Expose @SerializedName("front_default") val frontDefault: String?,
)