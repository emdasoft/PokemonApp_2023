package com.emdasoft.pokemonapp2023.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("pokemon_info")
data class PokeInfoDbModel(
    @PrimaryKey
    val id: Int,
    val name: String,
    val weight: Int,
    val height: Int,
    val sprite: String?,
    val types: List<String>
)