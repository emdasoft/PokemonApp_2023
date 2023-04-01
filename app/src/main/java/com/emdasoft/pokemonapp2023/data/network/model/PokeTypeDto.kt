package com.emdasoft.pokemonapp2023.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PokeTypeDto(
    @Expose @SerializedName("name") val name: String
)